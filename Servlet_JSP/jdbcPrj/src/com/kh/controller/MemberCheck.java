package com.kh.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberCheck")
public class MemberCheck extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/memberCheck.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String id = "KH";
		String pwd = "KH";
		
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			// select 결과 집합을 가져오기위해 executeQeury() 사용하고 ResultSet에 담음
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			
			String memberId = rs.getString("ID");
			String memberPwd = rs.getString("PWD");
			String memberName = rs.getString("NAME");
			Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
			
			System.out.println(memberId);
			System.out.println(memberPwd);
			System.out.println(memberName);
			System.out.println(enrollDate);
			}
			
			pstmt.close();
			rs.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
