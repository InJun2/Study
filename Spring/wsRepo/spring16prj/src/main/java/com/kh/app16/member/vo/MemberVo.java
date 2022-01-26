package com.kh.app16.member.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MemberVo {
	private String id;
	private String pwd;
	private String nick;
	private List<MultipartFile> profilelist;
	
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public List<MultipartFile> getProfilelist() {
		return profilelist;
	}
	public void setProfilelist(List<MultipartFile> profilelist) {
		this.profilelist = profilelist;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", profilelist=" + profilelist + "]";
	}
	public boolean fileValidation() {
		if(profilelist.get(0).isEmpty() || profilelist.size() <1 || profilelist == null || profilelist.get(0) == null) {
			return false;
		}
		return true;
	}
	
}
