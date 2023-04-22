package com.CoinFiesta.CoinFiesta.service.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.CoinFiesta.CoinFiesta.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
		
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getUser_password();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUser_id();
	}
	
	/*
	 * 계정 만료 여부
	 * true : 만료 x
	 * false : 만료
	 */

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/*
	 * 계정 잠김 여부
	 * true : 잠기지 않음
	 * false : 잠김
	 */

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * 비밀번호 만료 여부
	 * true : 만료 x
	 * false : 만료
	 */
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/*
	 * 사용자 활성화 여부
	 * true : 활성화
	 * false : 비활성화
	 */
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



}
