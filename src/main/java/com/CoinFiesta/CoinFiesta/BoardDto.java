package com.CoinFiesta.CoinFiesta;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDto {
	private String title;
	private String content;
}
