package com.CoinFiesta.CoinFiesta.domain.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  BoardRepository {
	
	//문의사항 작성
	public int save(Board borad) throws Exception; //db에서 결과가 확인 됐고,
	
	public Board findBoardByBoardcode(int boardcode) throws Exception;
	
	public List<Board> readBoardList(Map<String, Object> map) throws Exception;
	
	
}
