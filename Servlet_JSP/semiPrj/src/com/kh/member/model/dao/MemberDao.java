package com.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.member.model.vo.MemberVo;

public class MemberDao {

	public int insertMember(Connection conn, MemberVo m) throws SQLException {
		
		String sql = "insert into member(member_no, id, pwd, name, detail, enroll_date) values (seq_member.nextval, ?, ?, ?, ?, sysdate)";
		
		PreparedStatement pstmt = null;
		
		int result= 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, -1);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}		

		return result;
	}
	
	public MemberVo selectMember(Connection conn, MemberVo m) {
		String query = "select * from member where id =? and quit_yn ='N'";
		
		PreparedStatement pstmt = null;
		MemberVo selectedMember = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				int detail = rs.getInt("DETAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String openYn = rs.getString("OPEN_YN");
				
				selectedMember = new MemberVo();
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setDetail(detail);
				selectedMember.setEnrollDate(enrollDate);
				selectedMember.setModifyDate(modifyDate);
				selectedMember.setOpenYn(openYn);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return selectedMember;
	}

	public List<MemberVo> selectMemberAll(Connection conn) {
		String sql = "SELECT * FROM MEMBER WHERE QUIT_YN = 'N' AND OPEN_YN = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> list = new ArrayList<MemberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			MemberVo selectedMember = null;
			
			while(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				int detail = rs.getInt("DETAIL");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String openYn = rs.getString("OPEN_YN");
				
				selectedMember = new MemberVo();
				selectedMember.setMemberNo(memberNo);
				selectedMember.setId(id);
				selectedMember.setPwd(pwd);
				selectedMember.setName(name);
				selectedMember.setDetail(detail);
				selectedMember.setEnrollDate(enrollDate);
				selectedMember.setModifyDate(modifyDate);
				selectedMember.setOpenYn(openYn);
				
				list.add(selectedMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
}
