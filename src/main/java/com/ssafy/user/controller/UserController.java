package com.ssafy.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.jwt.model.service.JwtServiceImpl;
import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api("게시판 컨트롤러  API V1")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@ApiOperation(value = "아이디 중복체크", notes = "아이디 중복체크를 한다 ", response = Map.class)
	@PostMapping("/idcheck")
	public ResponseEntity<Map<String, Object>> idDupCheck(
			@RequestBody @ApiParam(value = "회원가입 양식", required = true) UserDto userDto) {

		logger.info("아이디 중복 체크 - 호출");

		HttpStatus status = null;
		Map<String, Object> resultMap = new HashMap<>();

		if (userService.idDupCheck(userDto.getUserId())) {
			resultMap.put("message", "success");
			status = HttpStatus.ACCEPTED;
		} else {
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "패스워드 찾기", notes = "아이디, 이메일 기반으로 패스워드를 찾는다.", response = Map.class)
	@PostMapping("/findpwd")
	public ResponseEntity<Map<String, Object>> findpwd(
			@RequestBody @ApiParam(value = "패스워드를 찾기 위한 아이디, 이메일 정보", required = true) UserDto userDto) {

		logger.info("비밀번호 찾기 - 호출");

		HttpStatus status = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String userPwd = null;

		userPwd = userService.findPw(userDto.getUserId(), userDto.getUserEmail());
		
		if (userPwd != null) {
			resultMap.put("message", "success");
			resultMap.put("userInfo", userPwd);
			status = HttpStatus.ACCEPTED;
		} else {
			resultMap.put("message", "fail");
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원가입", notes = "양식을 받아 회원가입을 한다. ", response = String.class)
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody @ApiParam(value = "회원가입 양식", required = true) UserDto userDto) {

		logger.info("회원가아아아입 - 호출");
		logger.debug("회원가입 호출!! : {}", userDto);

		if (userService.signUp(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ApiOperation(value = "회원탈퇴", notes = "유저 아이디 기반으로 회원 탈퇴를 진행한다.", response = String.class)
	@PostMapping("/withdraw")
	public ResponseEntity<?> withdraw(
			@RequestBody @ApiParam(value = "유저 아이디") UserDto userDto) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(userDto.getUserId());
		logger.debug("회원 탈퇴 호출!! : {}", userDto.getUserId());
		if(userService.signIn(userDto)==null) {
			resultMap.put("message", FAIL);
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}else {
			userService.withdraw(userDto);
			System.out.println("들어옴?");
			resultMap.put("message", SUCCESS);
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}

	}
	
	
	@ApiOperation(value = "마이페이지", notes = "마이 페이지 정보를 출력한다.", response = String.class)
	@GetMapping("/mypage/{userId}")
	public ResponseEntity<Map<String, Object>> myPage(@PathVariable("userId") @ApiParam(value = "회원정보", required = true) String userId) {

		logger.debug("사용자 id 호출!! : {}", userId);
		Map<String, Object> map = new HashMap<>();
		map.put("userInfo", userService.userInfo(userId));
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	}
	
	@ApiOperation(value = "회원수정", notes = "회원정보를 수정한다.", response = String.class)
	@PutMapping("modify")
	public ResponseEntity<String> modify(@RequestBody @ApiParam(value = "수정할 회원정보", required = true) UserDto userDto) {
		
		logger.debug("회원수정 호출!! : {}", userDto);
		
		System.out.println(userDto.getUserId());
		System.out.println(userDto.getUserEmail());
		if (userService.userModify(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}