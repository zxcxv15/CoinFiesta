package com.CoinFiesta.CoinFiesta.service.Board;

import com.CoinFiesta.CoinFiesta.web.dto.Board.CreateBoardReqDto;

public interface BoardService {

	public boolean writeBoard(CreateBoardReqDto boardReqDto) throws Exception;
	
}
