package com.example.demo.member.vo;

import javax.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVo {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userAuthority;

}

