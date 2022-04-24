package com.example.demo.security.userservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.member.vo.MemberVo;
import com.example.demo.security.user.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	
	private MemberMapper mapper;

	public CustomUserDetailsService(MemberMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo userInfo = mapper.selectId(username);	// db에서 userId를 이용하여 찾고 memberVo에 보관
		
		if(userInfo == null) {
			log.error("존재하지 않는 Id : " + username);
			throw new UsernameNotFoundException("해당 아이디를 가진 유저를 찾을 수 없습니다");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(userInfo.getUserAuthority()));
			
		CustomUserDetails user = new CustomUserDetails(userInfo.getUserId(), userInfo.getUserPwd(), authorities);	// memberVo가 null이 아니라면 UserDetails를 상속받는 CustomUserDetails 객체에 해당 memberVo 값 넣기
		
		return user;
	}

}
