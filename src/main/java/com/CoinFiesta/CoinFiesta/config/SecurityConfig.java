package com.CoinFiesta.CoinFiesta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.CoinFiesta.CoinFiesta.config.auth.AuthFailureHandler;

@EnableWebSecurity // 현재 시큐리티 설정을 따른다.
@Configuration
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable(); 										// csrf 토큰 발급 x
		http.authorizeRequests() 									// 요청이 들어왔을 때 인증하는 세팅
			
			.antMatchers("/","/board/write","/board/detail")		// 내가 지정한 요청
			.authenticated()										// 인증을 거친다.
			.anyRequest()   										// 다른 모든 요청들은
			.permitAll()											// 모든 접근 권한을 준다.
			.and()													// 그리고
			.formLogin()											// form 로그인을 한다.
			.usernameParameter("userid")
			.loginPage("/auth/signin")								// 로그인 페이지 해당 get요청을 통해 접근한다.

			.failureHandler(new AuthFailureHandler())
			
			.defaultSuccessUrl("/");
		
		return http.build();
	}


}