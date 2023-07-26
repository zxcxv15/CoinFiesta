package com.CoinFiesta.CoinFiesta.web.dto.board;

import com.CoinFiesta.CoinFiesta.domain.board.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateBoardRespDto {
	private int boardcode;
	private String title;
	private String content;
	
	
		public Board toEntity() {
			
			return Board.builder()
						.board_code(boardcode)
						.title(title)
						.content(content)
						.build();
						
		}
}
