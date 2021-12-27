package com.kh.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplate {
	// jdbc 하면서 계속 쓰는 것 static 처리해서 사용
	// commit 
	// rollback
	// close ( conn, pstmt, stmt, rs )
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Statement 메소드에서 preparedstatement도 포함됨 
//	public static void close(PreparedStatement pstmt) {
//		try {
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
