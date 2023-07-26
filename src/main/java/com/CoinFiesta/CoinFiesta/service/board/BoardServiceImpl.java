package com.CoinFiesta.CoinFiesta.service.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.CoinFiesta.CoinFiesta.domain.board.Board;
import com.CoinFiesta.CoinFiesta.domain.board.BoardRepository;
import com.CoinFiesta.CoinFiesta.web.dto.board.CreateBoardReqDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.CreateCommentReqDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.ReadBoardRespDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.UpdateBoardRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	@Override
	public boolean createBoard(CreateBoardReqDto createboardReqDto) throws Exception {
		return boardRepository.save(createboardReqDto.toEntity()) > 0 ; 
		// repository로 넘길 떄 entity로 변환 후 전달
		// 1건이 조회 된다면, 0보다 크기 떄문에 true가 나온다.
	}
	
	//게시글 리스트 조회
		@Override
		public List<ReadBoardRespDto> readBoardList(int page) throws Exception {
			int index = (page - 1) * 10;
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("index", index);
			
			List<ReadBoardRespDto> boardlist = new ArrayList<ReadBoardRespDto>();
			
			
			boardRepository.readBoardList(map).forEach(board -> {
				
				boardlist.add(board.toReadBoardDto());
			});;
			return boardlist;
		}

	//게시글 상세 조회
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

	@Override
	public boolean deleteBoard(int boardcode) throws Exception {
		
		return boardRepository.deleteBoard(boardcode) > 0;
	}
	
	@Override
	public boolean updateBoard(UpdateBoardRespDto updateBoardRespDto) throws Exception {
		
		return boardRepository.updateBoardByBoardCode(updateBoardRespDto.toEntity()) > 0;
	}
	
	@Override
	public boolean createComment(CreateCommentReqDto commentReqDto) throws Exception {
		
		return boardRepository.insertComment(commentReqDto.toEntity()) > 0 ; 
	}

}
