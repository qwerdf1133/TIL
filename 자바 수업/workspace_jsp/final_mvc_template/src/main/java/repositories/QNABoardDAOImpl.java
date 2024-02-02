package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BoardVO;
import util.Criteria;
import util.DBCPUtil;

public class QNABoardDAOImpl implements QNABoardDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	@Override
	public int getListCount() {
		
		String sql = "SELECT count(*) FROM qna";
		
		conn = DBCPUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs, pstmt, conn);
		}
		
		return 0;
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM qna_board ORDER BY qna_re_ref DESC, qna_re_seq ASC limit ?, ?";
		
		Connection conn = DBCPUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getStartRow());
			pstmt.setInt(2, cri.getPerPageNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = getResultVO(rs);
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs,pstmt,conn);
		}
				
		return list;
	}
	
	private BoardVO getResultVO(ResultSet rs) throws SQLException {
		BoardVO board = new BoardVO(
			rs.getInt("qna_num"),
			rs.getString("qna_name"),
			rs.getString("qna_title"),
			rs.getString("qna_content"),
			rs.getInt("qna_re_ref"),
			rs.getInt("qna_re_lev"),
			rs.getInt("qna_re_seq"),
			rs.getInt("qna_writer_num"),
			rs.getInt("qna_readcount"),
			rs.getString("qna_delete").charAt(0),
			rs.getTimestamp("qna_date")
		);
		return board;
	}
	

	@Override
	public void boardWrite(BoardVO board) {
		// 삽입된 원본글 번호로 그룹으로 묶을 수 있도록
		// qna_re_ref 컬럼 값을 등록된 게시글 번호로 지정
		
		String sql = "INSERT INTO qna VALUE(null,?,?,?,0,0,0,?,0,'N',now())";
		conn = DBCPUtil.getConnection();
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getQna_name());
			pstmt.setString(2, board.getQna_title());
			pstmt.setString(3, board.getQna_content());
			pstmt.setInt(4, board.getQna_writer_num());
			pstmt.executeUpdate();
			
			DBCPUtil.close(pstmt);
			
			sql = "UPDATE qna SET qna_re_ref = LAS_INSERT_ID() WHERE qna_num = LAST_INSERT_ID()";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {}
			DBCPUtil.close(pstmt, conn);
		}
	}

	@Override
	public BoardVO getBoardVO(int board_num) {
		String sql = "SELECT * FROM qna WHERE qna_num = ?";
		conn = DBCPUtil.getConnection();
		BoardVO board = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = getResultVO(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(rs, pstmt, conn);
		}
		
		return null;
	}

	@Override
	public void updateReadCount(int board_num) {
		String sql = "UPDATE qna SET qna_readcount = qna_readcount +1 WHERE qna_num = ?";
		
		conn = DBCPUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(pstmt, conn);
		}
	}

	@Override
	public void boardReplySubmit(BoardVO board) {
		int origin_ref = board.getQna_re_ref();
		int origin_lev = board.getQna_re_lev();
		int origin_seq = board.getQna_re_seq();
		
		String seqsql = "UPDATE qna SET qna_re_seq = qna_re_seq + 1 WHERE qna_re_ref = ? AND qna_re_seq > ?"; 
		
		conn = DBCPUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(seqsql);
			pstmt.setInt(1, origin_ref);
			pstmt.setInt(2, origin_seq);
			
			DBCPUtil.close(pstmt);
			
			String sql = "INSERT INTO qna VALUES(null,?,?,?,?,?,?,0'N',now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getQna_name());
			pstmt.setString(2, board.getQna_title());
			pstmt.setString(3, board.getQna_content());
			pstmt.setInt(4, origin_ref);
			pstmt.setInt(5, origin_seq + 1);
			pstmt.setInt(6, origin_seq + 1);
			pstmt.setInt(7, board.getQna_writer_num());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(pstmt,conn);
		}
		
	}

	@Override
	public void boardUpdate(BoardVO board) {
		String sql = "UPDATE qna SET qna_name = ? qna_title = ? qna_content = ? WHERE qna_num = ? AND qna_writer_num = ? ";
		conn = DBCPUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getQna_name());
			pstmt.setString(2, board.getQna_title());
			pstmt.setString(3, board.getQna_content());
			pstmt.setInt(4, board.getQna_num());
			pstmt.setInt(5, board.getQna_writer_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtil.close(pstmt, conn);
		}
	}

	@Override
	public boolean boardDelete(int board_num, int qna_writer_num) {
		
		String sql = "UPDATE qna SET qna_delete = 'Y' WHERE qna_num = ? AND qna_writer_num = ? ";
		conn = DBCPUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.setInt(2, qna_writer_num);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		} catch (SQLException e) {
			
		} finally {
			DBCPUtil.close(pstmt, conn);
		}
		
		return false;
	}

}
