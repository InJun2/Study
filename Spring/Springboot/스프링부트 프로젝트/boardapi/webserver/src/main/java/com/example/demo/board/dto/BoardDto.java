package com.example.demo.board.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Date boardDate;
	
	public BoardDto() {
		
	}
	
	public BoardDto(String title, String content, String writer) {
		this.boardTitle = title;
		this.boardContent = content;
		this.boardWriter = writer;
	}
}
