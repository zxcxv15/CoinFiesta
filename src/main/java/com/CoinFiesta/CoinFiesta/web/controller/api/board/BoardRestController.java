package com.CoinFiesta.CoinFiesta.web.controller.api.board;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CoinFiesta.CoinFiesta.service.board.BoardService;
import com.CoinFiesta.CoinFiesta.web.dto.CMRespDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.CreateBoardReqDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.CreateCommentReqDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.ReadBoardRespDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.UpdateBoardRespDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@Slf4j
public class BoardRestController {

	private final BoardService boardService;
	

	//게시글 작성
	@PostMapping("/write")
	public ResponseEntity<?> boardWrite(CreateBoardReqDto createboardReqDto){//JSON 데이터를 받기위해서는 @RequestBody를 사용해야한다.
		log.info("data: {}", createboardReqDto);
		 boolean status = false;
		try {
			status = boardService.createBoard(createboardReqDto); // controller -> service(writeBoard에 boardReqDto를)로 넘겨준다.
		} catch (Exception e) {									// boolean 값이 들어와서 비교 한다.
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(1, "Failed to write", status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "completing creation", status));
	}
	
	//게시글 목록 조회
	@GetMapping("/list/{page}")
	public ResponseEntity<?> getBoardList(@PathVariable int page){
		List<ReadBoardRespDto> listDto = null;
		
		try {
			listDto = boardService.readBoardList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1,"database error",listDto));	
		}
		return ResponseEntity.ok(new CMRespDto<>(1,"lookup successful", listDto));
	}
	
	
	//게시글 상세페이지 조회
	@GetMapping("/detail/{boardcode}")
	public ResponseEntity<?> getBoard(@PathVariable int boardcode) {
		ReadBoardRespDto readBoardRespDto = null;
		try {
			readBoardRespDto = boardService.readBoard(boardcode);
			if(readBoardRespDto == null) {
				return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "request failed", null));
			}
		} catch (Exception e) {
			e.printStackTrace();
				return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Server error", null));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup successful", readBoardRespDto));
	}
	
	
		//게시글 수정
		@PutMapping("/update/{boardcode}")
		public ResponseEntity<?> updateBoard(@PathVariable int boardcode, @RequestBody UpdateBoardRespDto updateboardReqDto) {
			boolean status = false;
			
			try {
				updateboardReqDto.setBoardcode(boardcode);
				status = boardService.updateBoard(updateboardReqDto);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "failed", status));
			}
			
			return ResponseEntity.ok().body(new CMRespDto<>(1, "success", status));
		}
	
	//게시글 상세페이지 삭제
	@DeleteMapping("/delete/{boardcode}")
	public ResponseEntity<?> getBoardDelete(@PathVariable int boardcode) {
		
		boolean status = false;
		
		try {
			status = boardService.deleteBoard(boardcode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Server error", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "lookup success", status));
	}
	
	//게시글 댓슬작성
		@PostMapping("/commentWrite/{boardcode}")
		public ResponseEntity<?> commendWrite(@PathVariable int boardcode, @RequestBody CreateCommentReqDto createboardReqDto){
			log.info("data: {}", createboardReqDto);
			 boolean status = false;
			try {
				createboardReqDto.setBoardcode(boardcode);
				status = boardService.createComment(createboardReqDto); // controller -> service(writeBoard에 boardReqDto를)로 넘겨준다.
			} catch (Exception e) {									// boolean 값이 들어와서 비교 한다.
				e.printStackTrace();
				return ResponseEntity.internalServerError().body(new CMRespDto<>(1, "Failed to write", status));
			}
			return ResponseEntity.ok().body(new CMRespDto<>(1, "completing creation", status));
		}
	
	
}
