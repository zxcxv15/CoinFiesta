package com.CoinFiesta.CoinFiesta.web.dto.Board;

import com.CoinFiesta.CoinFiesta.domain.Board.Board;

import lombok.Data;

@Data
public class CreateBoardReqDto {
	private String title;
	private String content;
	
//객체를 entity를 변환
	public Board toEntity() {
		return Board.builder()
				.title(title)
				.content(content)
				.build();
	}
}
