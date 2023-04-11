package com.CoinFiesta.CoinFiesta.domain.Board;

import java.time.LocalDateTime;

import com.CoinFiesta.CoinFiesta.web.dto.Board.ReadBoardListRespDto;
import com.CoinFiesta.CoinFiesta.web.dto.Board.ReadBoardRespDto;

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
	private LocalDateTime create_date;
	
	public ReadBoardRespDto toReadBoardDto() {
		return ReadBoardRespDto.builder()
				.boardcode(board_code)
				.title(title)
				.content(content)
				.createdate(create_date)
				.build();
	}
	
	public ReadBoardListRespDto toBoardListDto() {
		return ReadBoardListRespDto.builder()
				.boardcode(board_code)
				.title(title)
				.createdate(create_date)
				.build();
	}

}