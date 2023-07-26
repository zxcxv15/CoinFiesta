package com.CoinFiesta.CoinFiesta.web.controller.api.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CoinFiesta.CoinFiesta.service.auth.AuthService;
import com.CoinFiesta.CoinFiesta.service.auth.PrincipalDetails;
import com.CoinFiesta.CoinFiesta.web.dto.CMRespDto;
import com.CoinFiesta.CoinFiesta.web.dto.auth.SignupReqDto;
import com.CoinFiesta.CoinFiesta.web.dto.auth.ValidationReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthRestController {

	private final AuthService authService;
	
	/** 회원가입 관련 소스*/
	
	//유저 정보 가져오기
	@GetMapping("/principal")
	public ResponseEntity<?> getPrincipal(@AuthenticationPrincipal PrincipalDetails principalDetails){
		if(principalDetails == null) {
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1,"principal is null", null));
		}
		return ResponseEntity.ok(new CMRespDto<>(1,"success load", principalDetails.getUser()));
	}
	
	//회원가입
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody  SignupReqDto signupReqDto){
		log.info("data: {}", signupReqDto);

		 boolean status = false;
		try {
			status = authService.signup(signupReqDto);
		} catch (Exception e) {									
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(1, "signup failed", status));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "signup successful", status));
	}
	
	//아이디 체크
	@GetMapping("/signup/validation/userid")
	public ResponseEntity<?> checkUserid(ValidationReqDto validationReqDto){

		boolean status = false;
		
		try {
			status = authService.checkUserid(validationReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Server error", status));

		}
		return ResponseEntity.ok(new CMRespDto<>(1, "signup registration availability", status));
	}
	
	//이메일체크
		@GetMapping("/signup/validation/useremail")
		public ResponseEntity<?> checkUseremail(ValidationReqDto validationReqDto){

			boolean status = false;
			
			try {
				status = authService.checkUseremail(validationReqDto);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Server error", status));

			}
			return ResponseEntity.ok(new CMRespDto<>(1, "signup registration availability", status));
		}
}
	