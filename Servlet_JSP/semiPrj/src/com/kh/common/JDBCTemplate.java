package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// 커넥션 가져오기 > 커밋 > 롤백 > close
	public static Connection getConncetion() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String id = "KH";
		String pwd = "KH";
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			conn.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void commit(Connection conn) {
		try {
			// null, isClosed 확인
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			// null, isClosed 확인
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		try {
			// null, isClosed 확인
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			// null, isClosed 확인
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			// null, isClosed 확인
			if(rs != null && !rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
