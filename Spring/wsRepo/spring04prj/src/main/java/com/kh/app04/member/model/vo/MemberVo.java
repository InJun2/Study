package com.kh.app04.member.model.vo;

public class MemberVo {
	private String id;
	private String pwd;
	private String nick;	// 화면에서 controller에서 값을 전달할때 동일해야하는것은 해당 객체의 이름이 아닌 set객체의 이름과 화면에서 넘어갈 값의 이름이 같아야함을 알 수 있음
	private int age;
	
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

	public String getName() {
		return nick;
	}

	public void setName(String name) {
		this.nick = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
