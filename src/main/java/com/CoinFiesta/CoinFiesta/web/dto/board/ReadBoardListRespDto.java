package com.CoinFiesta.CoinFiesta.web.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReadBoardListRespDto {
	private int boardcode;
	private String title;
	private String content;
	private String username;
	private int usercode;
	private String  createdate;
	private String  updatedate;
}
