package account.dao.pstmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import account.dao.AccountDAO;
import account.dto.AccountDTO;
import utils.DBUtill;

public class AccountPSTMTDAOImpl implements AccountDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	@Override
	public void insert(AccountDTO account) {
		// 작성
		String sql = "INSERT INTO tbl_account VALUES(?,?,?,?)";
		conn = DBUtill.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAno());
			pstmt.setString(2, account.getOwner());
			pstmt.setInt(3, account.getBalance());
			pstmt.setString(4, account.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(pstmt);
		}
		
	}

	@Override
	public int update(AccountDTO account) {
		int result = 0;
		// 작성
		String sql = "UPDATE tbl_account SET balance = ? WHERE ano = ? ";
		conn = DBUtill.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account.getBalance());
			pstmt.setString(2, account.getAno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(pstmt);
		}
		
		
		return result;
	}

	@Override
	public AccountDTO selectAccount(String ano) {
		AccountDTO account = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = ?";
		conn = DBUtill.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			rs = pstmt.executeQuery();
			
			account = getAccount(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// rs, pstmt 
			DBUtill.close(rs,pstmt);
			
//			DBUtill.close(rs);
//			DBUtill.close(pstmt);
		}
		return account;
		
	}
	
	public AccountDTO getAccount(ResultSet rs) throws SQLException {
		AccountDTO account = null;
		// 작성
		if(rs.next()) {
			account = new AccountDTO(
				rs.getString(1),		// ano
				rs.getString(2),		// owner
				rs.getInt(3),			// balance
				rs.getString(4)			// password
			);
		}
		return account;
	}
	@Override
	public AccountDTO selectAccount(String ano, String password) {
		AccountDTO account = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = ? AND password = ?";
		conn = DBUtill.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			account = getAccount(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(rs, pstmt);
		}
		
		return account;
	}

}







