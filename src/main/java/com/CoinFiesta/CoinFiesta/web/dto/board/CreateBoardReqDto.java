package com.CoinFiesta.CoinFiesta.web.dto.board;

import com.CoinFiesta.CoinFiesta.domain.board.Board;

import lombok.Data;

@Data
public class CreateBoardReqDto {
	private int usercode;
	private String title;
	private String content;
	
//객체를 entity를 변환
	public Board toEntity() {
		return Board.builder()
				.user_code(usercode)
				.title(title)
				.content(content)
				.build();
	}
}
