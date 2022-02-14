package com.kh.app.member.entity;

import lombok.Data;

@Data
public class MemberDto {
	private long userNo;
	private String userId;
	private String userPwd;
	private String userNick;
	private int userAge;
	private String userGender;
	private String userProfile;
	
}
