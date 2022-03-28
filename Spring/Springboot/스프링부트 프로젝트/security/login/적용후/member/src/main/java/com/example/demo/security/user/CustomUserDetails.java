package com.example.demo.security.user;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> userAuthority;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userAuthority;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setUserAuthority(Collection<? extends GrantedAuthority> userAuthority) {
		this.userAuthority = userAuthority;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public CustomUserDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}

	
	
}
