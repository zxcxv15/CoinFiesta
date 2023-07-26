package com.CoinFiesta.CoinFiesta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.CoinFiesta.CoinFiesta.config.auth.CustomAuthenticationFailureHandler;

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
		http.headers()
	    .cacheControl().disable();
		http.authorizeRequests() 									// 요청이 들어왔을 때 인증하는 세팅
			
			.antMatchers("/board/write")						// 내가 지정한 요청S
			.authenticated()										// 인증을 거친다.
			.anyRequest()   										// 다른 모든 요청들은
			.permitAll()											// 모든 접근 권한을 준다.
			
			.and()
			.formLogin()											// form 로그인을 한다.
			.usernameParameter("userid")
			.loginPage("/auth/signin")								// 로그인 페이지 해당 get요청을 통해 접근한다.
			
			.failureHandler(new CustomAuthenticationFailureHandler())
			.defaultSuccessUrl("/main")
			
			
			  
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //로그아웃을 호출할 경우 해당 경로 
			.logoutSuccessUrl("/auth/signin") //로그아웃이 성공했을 경우 해당 경로 
			.invalidateHttpSession(true); //로그아웃시 인증정보를 지우고 세션을 무효화 시키는 설정
			
		
		return http.build();
	}


}