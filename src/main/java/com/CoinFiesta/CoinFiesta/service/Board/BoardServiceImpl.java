package com.CoinFiesta.CoinFiesta.service.Board;

import org.springframework.stereotype.Service;

import com.CoinFiesta.CoinFiesta.domain.Board.Board;
import com.CoinFiesta.CoinFiesta.domain.Board.BoardRepository;
import com.CoinFiesta.CoinFiesta.web.dto.Board.CreateBoardReqDto;
import com.CoinFiesta.CoinFiesta.web.dto.Board.ReadBoardRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	@Override
	public boolean createBoard(CreateBoardReqDto boardReqDto) throws Exception {
		return boardRepository.save(boardReqDto.toEntity()) > 0 ; 
		// repository로 넘길 떄 entity로 변환 후 전달
		// 1건이 조회 된다면, 0보다 크기 떄문에 true가 나온다.
	}


	@Override
	public ReadBoardRespDto readBoard(int boardcode) throws Exception {
		Board boardEntity = null;
		ReadBoardRespDto readBoardRespDto = null;
		
		boardEntity = boardRepository.findBoardByBoardcode(boardcode);
		
		if(boardEntity != null) {
			readBoardRespDto = boardEntity.toReadBoardDto();
		}
		
		return readBoardRespDto;
	}






}