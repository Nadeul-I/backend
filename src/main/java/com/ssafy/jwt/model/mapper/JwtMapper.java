package com.ssafy.jwt.model.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface JwtMapper {
	
	boolean saveRefreshToken(String userId, String refreshToken);

	Object getRefreshToken(String userId);

	boolean deleteRefreshToken(Map<String, String> map);
}
