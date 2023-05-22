package com.ssafy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.jwt.model.service.JwtService;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	public static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	private static final String HEADER_ACCESS = "access-token";
	private static final String HEADER_REFRESH = "refresh-token";

	@Autowired
	private JwtService jwtService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String accessToken = request.getHeader(HEADER_ACCESS);
		String refreshToken = request.getHeader(HEADER_REFRESH);

		logger.debug("accessToken: {}", accessToken);
		logger.debug("refreshToken: {}", refreshToken);

		if (accessToken != null && jwtService.checkToken(accessToken)) {
			logger.info("access 토큰 사용 가능 : {}", accessToken);
			return true;

		} else if (refreshToken != null) {
			String userId = jwtService.getUserId(refreshToken);
			if(userId == null || userId == "") return false;
			
			logger.info("refresh 토큰 사용 가능 : {}", refreshToken);
			
			accessToken = jwtService.createAccessToken("userId", userId);
			refreshToken = jwtService.createRefreshToken("userId", userId);
			
			jwtService.saveRefreshToken(userId, refreshToken);
			
			response.setHeader("access-token", accessToken);
			response.setHeader("refresh-token", refreshToken);
			
			return true;
		}

		return false;
	}

}
