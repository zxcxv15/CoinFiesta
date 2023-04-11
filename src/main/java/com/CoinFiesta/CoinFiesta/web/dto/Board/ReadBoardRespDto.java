package com.CoinFiesta.CoinFiesta.web.dto.Board;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReadBoardRespDto {
	private int boardcode;
	private String title;
	private String content;
	private LocalDateTime createdate;
}
