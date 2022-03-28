package com.example.demo.security.userservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.member.vo.MemberVo;
import com.example.demo.security.user.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo userInfo = mapper.selectUser(username);
		CustomUserDetails user = null;
		
		if(userInfo != null) {
			user = new CustomUserDetails(userInfo.getUserId(), userInfo.getUserPwd());
		
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(userInfo.getUserAuthority()));
			
			user.setUserAuthority(authorities);
		}
		
		return user;
	}

}
