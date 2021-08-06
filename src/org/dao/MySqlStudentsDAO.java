package org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bean.Student;

public class MySqlStudentsDAO implements IDAO, MySqlConstant {

	private static MySqlStudentsDAO dao = new MySqlStudentsDAO();
	
	private MySqlStudentsDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static MySqlStudentsDAO getInstance() {
		return dao;
	}
	
	@Override
	public Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, UID, UPW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void disconnect(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {} 
	}

	private void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {}
	}
	
	private void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {}
	}
	
	@Override
	public int insert(Connection con, Student student) {
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[INSERT]);
			pStmt.setString(1, student.getS_name());
			pStmt.setString(2, student.getS_tel());
			pStmt.setInt(3, student.getS_grade());
			pStmt.setString(4, student.getS_class());
			
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	@Override
	public int delete(Connection con, int s_id) {
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[DELETE]);
			pStmt.setInt(1, s_id);
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	@Override
	public int update(Connection con, Student student) {
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[UPDATE]);
			pStmt.setString(1, student.getS_tel());
			pStmt.setInt(2, student.getS_grade());
			pStmt.setString(3, student.getS_class());
			pStmt.setInt(4, student.getS_id());
			
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	private Student rowMapping(ResultSet rs) throws SQLException {
		int s_id = rs.getInt("s_id");
		String s_name = rs.getString("s_name");
		String s_tel = rs.getString("s_tel");
		int s_grade = rs.getInt("s_grade");;
		String s_class = rs.getString("s_class");;
		
		return new Student(s_id, s_name, s_tel, s_grade, s_class);
	}
	
	@Override
	public Student[] getAll(Connection con) {
		return search(con, GET_ALL, null);
	}

	@Override
	public Student[] search(Connection con, int mode, String key) {
		Student[] list = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = con.prepareStatement(SQLS[mode]);
			if (mode != GET_ALL) {
				pStmt.setString(1, key);
			}
			rs = pStmt.executeQuery();
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			list = new Student[count];
			for (int idx=0; rs.next(); idx++) {
				list[idx] = rowMapping(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pStmt);
		}
		return list;
	}
}
