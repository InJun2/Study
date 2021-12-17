package com.kh.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.kh.common.JdbcTemplate.*;
// static 메소드 호출을 편하게 하기 위해 com.kh.common.JdbcTemplate.* 임포트

@WebServlet("/member")
public class MemberController extends HttpServlet{
	
	
	// 회원가입 페이지 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/memberJoin.jsp").forward(req,resp);
	}
	
	// 회원가입 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  전달받은 데이터 디비에 넣기
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userName = req.getParameter("userName");
		
		// JDBC
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String id = "KH";
		String pwd = "KH";
		
//		String query = "INSERT INTO MEMBER (ID, PWD, NAME, ENROLL_DATE) VALUES ('"+userId+"','"+userPwd+"','"+userName+"', SYSDATE)";
		String query2 = "INSERT INTO MEMBER (ID, PWD, NAME, ENROLL_DATE) VALUES (?, ?, ? , SYSDATE)";
		
		// 1. driver를 lib에 등록 (jdbc를 WEB-INF/lib 에 저장)
		// 2. 클래스 등록
		// 3. 커넥션 가져옴 (getConnection)
		// 4. 쿼리를 실행할 Statment 혹은 prepareStatement 생성
		// 5. execute()로 실행
		
		// 밑에 sql 오류시 rollback, close 때문에 값이 존재해야 하므로 Connection에 null 입력
		Connection conn = null;
		PreparedStatement pstmt = null;
//		Statement stmt;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			// 자동 커밋 방지 설정
			conn.setAutoCommit(false);
			
			// Statement는 값을 미리적어놓지만 prepareStatement는 ?를 넣어두고 값을 넣을 수 있음 
//			stmt = conn.createStatement();	
//			stmt.execute(query);
			
			pstmt = conn.prepareStatement(query2);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			pstmt.setString(3, userName);
			
//			pstmt.execute();	// insert 실행만 하는 경우
			int result = pstmt.executeUpdate();
			commit(conn);
			System.out.println("업데이트 된 행의 갯수 (result) : " + result);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
			close(pstmt);
		}
	}
}
