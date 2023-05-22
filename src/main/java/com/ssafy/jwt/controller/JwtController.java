package com.ssafy.jwt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.controller.BoardController;
import com.ssafy.jwt.model.service.JwtService;
import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/auth")
@Api("게시판 컨트롤러  API V1")
public class JwtController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private JwtService jwtService;
	private UserService userService;

	public JwtController(JwtService jwtService, UserService userService) {
		super();
		this.jwtService = jwtService;
		this.userService = userService;
	}

	@ApiOperation(value = "로그인", notes = "로그인 성공시 accessToken, refreshToken을 반환한다", response = Map.class)
	@PostMapping("/signin")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) UserDto userDto)
			throws Exception {

		logger.info("유저 로그인 - 호출");

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;

		UserDto loginUser = userService.signIn(userDto);
		if (loginUser != null) {
			String accessToken = jwtService.createAccessToken("userId", loginUser.getUserId());// key, data
			String refreshToken = jwtService.createRefreshToken("userId", loginUser.getUserId());// key, data
			jwtService.saveRefreshToken(loginUser.getUserId(), refreshToken);

			logger.debug("로그인 accessToken 정보 : {}", accessToken);
			logger.debug("로그인 refreshToken 정보 : {}", refreshToken);

			resultMap.put("access-token", accessToken);
			resultMap.put("refresh-token", refreshToken);
			resultMap.put("message", SUCCESS);

			status = HttpStatus.ACCEPTED;
		} else {
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "인증된 회원 처리", notes = "토큰 시간을 갱신하고, 회원정보와 토큰을 담는다.", response = Map.class)
	@GetMapping("/check")
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest request) throws Exception {

		logger.info("토큰 갱신 - 호출");

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;

		String accessToken = request.getHeader("access-token");
		String refreshToken = request.getHeader("refresh-token");

		String userId = jwtService.getUserId(accessToken);
		
		jwtService.saveRefreshToken(userId, refreshToken);

		logger.debug("로그인 accessToken 정보 : {}", accessToken);
		logger.debug("로그인 refreshToken 정보 : {}", refreshToken);

		resultMap.put("access-token", accessToken);
		resultMap.put("refresh-token", refreshToken);
		resultMap.put("message", SUCCESS);

		status = HttpStatus.ACCEPTED;

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
	@GetMapping("/logout/{userId}")
	public ResponseEntity<?> removeToken(
			@PathVariable("userId") @ApiParam(value = "로그아웃할 회원 아이디.", required = true) String userId)
			throws Exception {

		logger.info("로그아웃 - 호출");

		if (jwtService.deleRefreshToken(userId))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

		return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(
			@RequestBody @ApiParam(value = "토큰 재발급 받을 회원", required = true) UserDto userDto, HttpServletRequest request)
			throws Exception {

		logger.info("토큰 재발급 - 호출");

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;

		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, userDto);

		if (jwtService.checkToken(token)) {
			if (token.equals(jwtService.getRefreshToken(userDto.getUserId()))) {// exceptionHandler 추가)
				String accessToken = jwtService.createAccessToken("userId", userDto.getUserId());

				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");

				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);

				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불가!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}
