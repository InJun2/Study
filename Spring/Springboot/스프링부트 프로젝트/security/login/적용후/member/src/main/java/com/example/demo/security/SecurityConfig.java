package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.security.authentication.CustomAuthenticationFilter;
import com.example.demo.security.authentication.CustomLoginSuccessHandler;
import com.example.demo.security.userservice.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/home").hasAnyAuthority("ROLE_ADMIN")
				.antMatchers("/A").hasAnyAuthority("ROLE_A", "ROLE_ADMIN")
				.antMatchers("/B").hasAnyAuthority("ROLE_B", "ROLE_ADMIN")
				.antMatchers("/login", "/", "/join").permitAll()
				.anyRequest().permitAll();	// 일단 그외 페이지 모두 허용해둠
		
		http
			.formLogin()
				.loginPage("/login")
				.usernameParameter("userId")
				.passwordParameter("userPwd")
				.defaultSuccessUrl("/A")
				.permitAll();
		http
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true);
		http
			.csrf().disable();
		http
			.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	
	 @Bean
	 public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
	     CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager());
	     customAuthenticationFilter.setFilterProcessesUrl("/login");
	     customAuthenticationFilter.setAuthenticationSuccessHandler(customLoginSuccessHandler());
	     customAuthenticationFilter.afterPropertiesSet();
	     return customAuthenticationFilter;
	 }
	 
	 @Bean
	 public CustomLoginSuccessHandler customLoginSuccessHandler() {
	     return new CustomLoginSuccessHandler();
	 }

}
