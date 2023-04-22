package com.CoinFiesta.CoinFiesta.service.board;

import java.util.List;

import com.CoinFiesta.CoinFiesta.web.dto.board.CreateBoardReqDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.ReadBoardRespDto;

public interface BoardService {

	public boolean createBoard(CreateBoardReqDto boardReqDto) throws Exception;
	
	public ReadBoardRespDto readBoard(int boardcode) throws Exception;
	
	public List<ReadBoardRespDto> readBoardList(int page) throws Exception;
	
}
