package com.CoinFiesta.CoinFiesta.web.dto.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.CoinFiesta.CoinFiesta.domain.user.User;

import lombok.Data;

@Data
public class SignupReqDto {	
	private String userid;
	private String password;
	private String username;
	private String useremail;
	
	public User toEntity() {
		return User.builder()
				.user_id(userid)
				.user_password(new BCryptPasswordEncoder().encode(password))
				.user_name(username)
				.user_email(useremail)
				.build();
	}
	
}