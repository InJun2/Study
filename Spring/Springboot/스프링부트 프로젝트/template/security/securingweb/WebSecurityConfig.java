package com.example.demo.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{	// 각 요청에 대해서 보안 수준을 잘 조절하기 위한 키는 WebSecurityConfigurerAdapter의 confiure 메소드 오버라이드임
	@Override
	protected void configure(HttpSecurity http) throws Exception {		// configure 설정 설명 ( https://kimchanjung.github.io/programming/2020/07/02/spring-security-02/ )
		http		// configure 메소드로 전달되는 HttpSecurity 객체는 몇가지 HTTP 보안의 관점을 설정하기 위해 사용 ( 특정 리소스의 접근 허용 또는 특정 권한을 지는 사용자만 접근을 가능하게 할 수있음 )
			.authorizeRequests()
				.antMatchers("/", "/home", "/hello").permitAll()		// antMatchers : 특정 리소스에 대해서 권한을 설정함, permitAll : antMatchers 설정한 리소스의 접근을 인증절차 없이 허용한다는 의미, 
//				.antMatchers("/hello/**").hasAnyRole("ADMIN")	// hasAnyRole : 리소스 hello으로 시작하는 URL은 인증후 ADMIN 레벨의 권한을 가진 사용자만 접근을 허용한다는 의미
				.anyRequest().authenticated()				// anyRequest : 모든 리소스 요청 시,  authenticated : 인증 필요
				.and()
			.formLogin()									// formLogin : 로그인 방식, 로그인 폼 페이지와 로그인 처리 성공, 실패를 사용한다는 의미 
				.loginPage("/login")						// loginPage : 사용자가 따로 만든 페이지를 사용하려고 할때 설정
//				.loginProcessingUrl("/login-process")		// loginProcessingUrl : 로그인 즉 인증처리를 하는 URL을 설정. /login-process가 호출되면 인증처리를 수행하는 필터가 호출
//              .defaultSuccessUrl("/main")					// defaultSuccessUrl : 정상적으로 인증성공했을 경우 이동하는 페이지 설정
//              .successHandler(new CustomAuthenticationSuccessHandler("/main"))	// successHandler : 정상적인 인증성공 후 별도의 처리가 필요한 경우 커스텀 핸들러를 생성하여 등록할 수 있음 ( 인증 성공 시 사용자가 추가한 로직 수행후 성공페이지로 이동 )
//              .failureUrl("login-fail")					// 인증이 실패했을경우 이동하는 페이지 설정
//              .failureHandler(new CustomAuthenticationFailureHandler("/login-fail"))	// 인증 실패 후 별도의 처리가 필요한 경우 커스텀 핸들러를 생성하여 등록할 수 있음
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.and()
			.csrf()
				.disable();							// csrf : 정상적인 사용자가 의도치않은 위조요청을 보내는 것을 의미, disable : 사용안함 ( rest api에서는 서버에 인증정보를 보관하지 않아 crsf 공격으로 부터 안전 ) 
	}
	
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = 
				User.withDefaultPasswordEncoder()
					.username("user")
					.password("password")
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(user);
	}
	

}
