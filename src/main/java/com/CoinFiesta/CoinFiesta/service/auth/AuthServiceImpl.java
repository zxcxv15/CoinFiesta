package com.CoinFiesta.CoinFiesta.service.auth;

import org.springframework.stereotype.Service;

import com.CoinFiesta.CoinFiesta.domain.user.UserRepository;
import com.CoinFiesta.CoinFiesta.web.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	
	@Override
	public boolean signup(SignupReqDto signupReqDto) throws Exception {
		
		return userRepository.save(signupReqDto.toEntity()) > 0;
	}


}
