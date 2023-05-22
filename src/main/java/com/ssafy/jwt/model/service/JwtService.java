package com.ssafy.jwt.model.service;

import java.util.Map;

public interface JwtService {

	<T> String createAccessToken(String key, T data) throws Exception;

	<T> String createRefreshToken(String key, T data) throws Exception;

	<T> String create(String key, T data, String subject, long expir) throws Exception;

	Map<String, Object> get(String key) throws Exception;

	String getUserId(String key) throws Exception;

	boolean checkToken(String jwt) throws Exception;

	boolean saveRefreshToken(String userId, String refreshToken) throws Exception;

	Object getRefreshToken(String userId) throws Exception;

	boolean deleRefreshToken(String userId) throws Exception;

}
