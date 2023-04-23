package com.CoinFiesta.CoinFiesta.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	
	/** 회원가입 관련 */
	public int save(User user) throws Exception;
	
	public User findUserByUserid(String userid) throws Exception;
	
	public User findUserByUseremail(String useremail) throws Exception;

	public User findUserByUsername(String username) throws Exception;

}
