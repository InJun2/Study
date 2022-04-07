package com.example.demo.board.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date boardDate;
	
	public BoardDto(String title, String content, String writer) {
		this.boardTitle = title;
		this.boardContent = content;
		this.boardWriter = writer;
	}
}
