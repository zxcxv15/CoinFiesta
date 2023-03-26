package com.CoinFiesta.CoinFiesta.domain;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NumberRepository {
	public int save(Number number);
}
