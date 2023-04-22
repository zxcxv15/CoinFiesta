package com.CoinFiesta.CoinFiesta.service.auth;

import com.CoinFiesta.CoinFiesta.web.dto.auth.SignupReqDto;

public interface AuthService {

	public boolean signup(SignupReqDto signupReqDto) throws Exception;
	
	
}
