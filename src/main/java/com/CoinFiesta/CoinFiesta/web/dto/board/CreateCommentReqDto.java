package com.CoinFiesta.CoinFiesta.web.dto.board;

import com.CoinFiesta.CoinFiesta.domain.board.Comment;

import lombok.Data;

@Data
public class CreateCommentReqDto {
	private int usercode;
	private int boardcode;
	private String content;
	
//객체를 entity를 변환
	public Comment toEntity() {
		return Comment.builder()
				.user_code(usercode)
				.board_code(boardcode)
				.content(content)
				.build();
	}
}
