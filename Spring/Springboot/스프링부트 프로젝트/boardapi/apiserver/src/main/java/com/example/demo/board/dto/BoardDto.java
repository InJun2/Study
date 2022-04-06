package com.example.demo.board.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Date boardDate;
	
	public BoardDto(String title, String content, String writer) {
		this.boardTitle = title;
		this.boardContent = content;
		this.boardWriter = writer;
	}
}
