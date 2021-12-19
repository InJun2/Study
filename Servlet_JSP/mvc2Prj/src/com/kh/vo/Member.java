package com.kh.vo;

public class Member {
	private String id;
	private String pwd;
	
	public Member(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void PrintMember() {
		System.out.println("id : " + id + "\n pwd : " + pwd);
	}
	
}
