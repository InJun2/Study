package com.example.demo.info.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)	// null이 아닌것만 return에 포함 됨
public class Project {
	
	private String projectName;
	
	@JsonProperty(value = "proejct master")	// 출력시 author이 아니라 "project master":"hello-bryan" 으로 출력됨
	private String author;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createDate;
	
	@JsonIgnore		// 해당 property는 Json 타입으로 리턴시 포함되지 않게 함
	private String deleteUser;
}
