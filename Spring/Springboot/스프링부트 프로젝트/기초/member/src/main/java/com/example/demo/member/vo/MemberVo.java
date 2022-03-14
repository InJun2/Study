package com.example.demo.member.vo;

import lombok.Data;

@Data
public class MemberVo {
	private int userNo;
	private String userId;
	private String userPwd;
	private int userAuthority;

	public String encriptionPwd(String pwd) {
		return pwd;
	}
}

