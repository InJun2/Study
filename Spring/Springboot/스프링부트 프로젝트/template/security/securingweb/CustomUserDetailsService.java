package com.example.demo.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService{	// 마찬가지로 DB에서 유저정보를 만들어둔 CustomUserDetail에 넣기위해 UserDetailsService를 구현 및 필요 메소드를 오버라이딩 

	@Autowired
	private UserDao dao;					// db를 조회하기 위한 repository 클래스
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails user = dao.getUserById(username);	// db에서 id를 조회해서 해당 아이디의 정보를 만들어둔 CustomUserDetail 객체에 저장 
        if(user==null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
	}

}
