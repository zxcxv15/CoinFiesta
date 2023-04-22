package com.CoinFiesta.CoinFiesta.service.auth;

import com.CoinFiesta.CoinFiesta.web.dto.auth.SignupReqDto;
import com.CoinFiesta.CoinFiesta.web.dto.auth.ValidationReqDto;

public interface AuthService {

	/** 회원가입 관련*/
	public boolean signup(SignupReqDto signupReqDto) throws Exception;
	
	public boolean checkUserid(ValidationReqDto validationReqDto) throws Exception;
	
	public boolean checkUseremail(ValidationReqDto validationReqDto) throws Exception;
	
	
	
	
	
}
