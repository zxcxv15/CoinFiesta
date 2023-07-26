package com.CoinFiesta.CoinFiesta.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CoinFiesta.CoinFiesta.service.auth.PrincipalDetails;
import com.CoinFiesta.CoinFiesta.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class PrincipalRestController {
	
	
	//유저 정보 가져오기
	@GetMapping("/principal")
	public ResponseEntity<?> getPrincipal(@AuthenticationPrincipal PrincipalDetails principalDetails){
		
		log.info("date{}: " +  principalDetails );
		
		if(principalDetails == null) {
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1,"principal is null", null));
		}
		return ResponseEntity.ok(new CMRespDto<>(1,"success load", principalDetails.getUser()));
	}
	
}
	