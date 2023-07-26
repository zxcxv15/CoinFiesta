package com.CoinFiesta.CoinFiesta.domain.board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.CoinFiesta.CoinFiesta.web.dto.board.ReadBoardListRespDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.ReadBoardRespDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.ReadCommentRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
	private int board_code;
	private String content;
	private int user_code;
	private LocalDateTime create_date;
	
	
	//게시글 리스트
	public ReadCommentRespDto toReadBoardDto() {
		return ReadCommentRespDto.builder()
				.boardcode(board_code)
				.content(content)
				.usercode(user_code)
				.createdate(create_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
				.build();
	}
	
}