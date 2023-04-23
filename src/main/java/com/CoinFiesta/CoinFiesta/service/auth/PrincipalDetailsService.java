package com.CoinFiesta.CoinFiesta.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CoinFiesta.CoinFiesta.domain.user.User;
import com.CoinFiesta.CoinFiesta.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		User userEntity = null;
		
		System.out.println(userid);
		try {
			userEntity = userRepository.findUserByUserid(userid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(userid);
		}
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(userid + "사용자 아이디는 사용할 수 없습니다.");
		}
		return new PrincipalDetails(userEntity);
	}


}
