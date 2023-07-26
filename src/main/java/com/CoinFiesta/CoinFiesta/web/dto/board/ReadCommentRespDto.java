package com.CoinFiesta.CoinFiesta.web.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReadCommentRespDto {
	private int boardcode;
	private String content;
	private int usercode;
	private String createdate;
}
