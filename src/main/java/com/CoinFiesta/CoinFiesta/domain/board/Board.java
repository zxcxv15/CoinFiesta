package com.CoinFiesta.CoinFiesta.domain.board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.CoinFiesta.CoinFiesta.web.dto.board.ReadBoardListRespDto;
import com.CoinFiesta.CoinFiesta.web.dto.board.ReadBoardRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	private int board_code;
	private String title;
	private String content;
	private String user_name;
	private int user_code;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	
	//게시글 리스트
	public ReadBoardRespDto toReadBoardDto() {
		return ReadBoardRespDto.builder()
				.boardcode(board_code)
				.title(title)
				.content(content)
				.username(user_name)
				.usercode(user_code)
				.createdate(create_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
				.updatedate(update_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
				.build();
	}
	
	
	//게시글 상세 불러올때껄 ?
	public ReadBoardListRespDto toBoardListDto() {
		return ReadBoardListRespDto.builder()
				.boardcode(board_code)
				.title(title)
				.content(content)
				.usercode(user_code)
				.username(user_name)
				.createdate(create_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
				.updatedate(update_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
				.build();
	}

}