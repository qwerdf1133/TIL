package com.bitc.board.backup;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitc.board.dao.BoardDAO;
import com.bitc.board.util.Criteria;
import com.bitc.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {
	
	private final SqlSession sqlSession;

	@Override
	public int create(BoardVO vo) throws Exception {
		int result = sqlSession.insert("boardMapper.create",vo);
		return result;
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		BoardVO vo = sqlSession.selectOne("boardMapper.read",bno);
		return vo;
	}

	@Override
	public int update(BoardVO vo) throws Exception {
		return sqlSession.update("boardMapper.update",vo);
	}

	@Override
	public int delete(int bno) throws Exception {
		return sqlSession.delete("boardMapper.delete",bno);
	}

	@Override
	public void updateCnt(int bno) throws Exception {
		sqlSession.update("boardMapper.updateCnt",bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return sqlSession.selectList("boardMapper.listAll");
	}

	@Override
	public int totalCount() throws Exception {
		return sqlSession.selectOne("boardMapper.totalCount");
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList("boardMapper.listCriteria",cri);
	}

}
