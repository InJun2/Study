package com.kh.app04.member.model.vo;

public class MemberVo {
	private String id;
	private String pwd;
	private String nick;	// ȭ�鿡�� controller���� ���� �����Ҷ� �����ؾ��ϴ°��� �ش� ��ü�� �̸��� �ƴ� set��ü�� �̸��� ȭ�鿡�� �Ѿ ���� �̸��� ���ƾ����� �� �� ����
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
