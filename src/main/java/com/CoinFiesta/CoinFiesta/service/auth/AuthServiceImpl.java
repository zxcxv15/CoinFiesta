package com.CoinFiesta.CoinFiesta.service.auth;

import org.springframework.stereotype.Service;

import com.CoinFiesta.CoinFiesta.domain.user.UserRepository;
import com.CoinFiesta.CoinFiesta.web.dto.auth.SignupReqDto;
import com.CoinFiesta.CoinFiesta.web.dto.auth.ValidationReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	
	@Override
	public boolean signup(SignupReqDto signupReqDto) throws Exception {
		
		return userRepository.save(signupReqDto.toEntity()) > 0;
	}

	@Override
	public boolean checkUserid(ValidationReqDto validationReqDto) throws Exception {
		
		return userRepository.findUserByUserid(validationReqDto.getUserid()) == null;
	}

	@Override
	public boolean checkUseremail(ValidationReqDto validationReqDto) throws Exception {
		
		return userRepository.findUserByUseremail(validationReqDto.getUseremail()) == null;
	}


}
