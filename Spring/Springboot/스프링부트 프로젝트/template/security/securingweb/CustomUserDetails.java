package com.example.demo.securingweb;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{	// UserDetails를 구현하여 해당 메소드들을 오버라이딩하였음, 사용자 정보를 담을 객체 ( UserDetails 인터페이스는 VO 역할을 한다고 보면 됨 ) 
														// ( https://to-dy.tistory.com/86 )
	
	// 추가로 필요힌 변수 생성 가능, 생성후 getter, setter 생성해서 사용
	private String ID;
	private String PASSWORD;
	private String AUTHORITY;
	private boolean ENABLED;
	private String NAME;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {	// 걔정이 가지고 있는 권한 목록 리턴
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(AUTHORITY));
        return auth;
	}

	@Override
	public String getPassword() {										// 계정의 비밀번호 리턴
		return PASSWORD;
	}

	@Override
	public String getUsername() {										// 게정의 이름 리턴
		return ID;
	}

	@Override
	public boolean isAccountNonExpired() {								// 계정이 만료되지 않았는지 리턴 ( true : 만료안됨 ), 이 메소드부터 밑의 메소드까지 체크할 필요가 없다면 로직없이 true 리턴
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {								// 계정이 잠겨있지 않았는지 리턴 ( true : 잠기지 않음 )
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {							// 비밀번호가 만료되지 않았는지 리턴 (true : 만료안됨 )
		return true;
	}

	@Override
	public boolean isEnabled() {										// 계정이 활성화(사용가능)인지 리턴 ( true: 활성화됨 )
		return ENABLED;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}
	
}
