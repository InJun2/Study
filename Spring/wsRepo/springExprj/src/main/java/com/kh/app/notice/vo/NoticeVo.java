package com.kh.app.notice.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVo {
	
	private long no;
	private String title;
	private String content;
	private long writer;
	private Date enroll;
	private String del;
	private String userNick;
}
