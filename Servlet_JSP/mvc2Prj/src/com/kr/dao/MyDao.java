package com.kr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.vo.Member;

public class MyDao {
	public void ddd(Member member) {
		System.out.println("DAO > ddd called");
		
		member.PrintMember();
		
		
		// JDBC
		// jdbc driver를 오라클에서 다운받은후 WEB-INF/lib 폴더안으로 카피
		// thin : dbms 접속시 사용되는 방식, 순수하게 자바 패키지만으로 바로 db와 연결, 범용성이 높고 상대적으로 OCI 보다 속도가 느림
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String id = "KH";
		String pwd = "KH";
		String sql = "SELECT 1 AS DATA FROM DUAL";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, id, pwd);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int data = rs.getInt("DATA");
				System.out.println("DB에서 가져온 데이터 : " + data);
				
			}
			rs.next();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	
	}
}
