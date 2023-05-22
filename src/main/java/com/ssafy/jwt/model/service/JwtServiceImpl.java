package com.ssafy.jwt.model.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.jwt.model.mapper.JwtMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {

	public static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

	@Autowired
	private JwtMapper jwtMapper;

//	SALT는 토큰 유효성 확인 시 사용하기 때문에 외부에 노출되지 않게 주의해야 한다.
	private static final String SALT = "ssafySecret";

	private static final int ACCESS_TOKEN_EXPIRE_MINUTES = 1; // 분단위
	private static final int REFRESH_TOKEN_EXPIRE_MINUTES = 2; // 주단위

	@Override
	public <T> String createAccessToken(String key, T data) throws Exception {
		return create(key, data, "access-token", 1000 * 60 * ACCESS_TOKEN_EXPIRE_MINUTES);
//		return create(key, data, "access-token", 1000 * 10 * ACCESS_TOKEN_EXPIRE_MINUTES);
	}

//	AccessToken에 비해 유효기간을 길게...
	@Override
	public <T> String createRefreshToken(String key, T data) throws Exception {
		return create(key, data, "refresh-token", 1000 * 60 * 60 * 24 * 7 * REFRESH_TOKEN_EXPIRE_MINUTES);
//		return create(key, data, "refresh-token", 1000 * 30 * ACCESS_TOKEN_EXPIRE_MINUTES);
	}

	@Override
	public <T> String create(String key, T data, String subject, long expire) throws Exception {

		Claims claims = Jwts.claims()
				// 토큰 제목 설정 ex) access-token, refresh-token
				.setSubject(subject)
				// 생성일 설정
				.setIssuedAt(new Date())
				// 만료일 설정 (유효기간)
				.setExpiration(new Date(System.currentTimeMillis() + expire));

		// 저장할 data의 key, value
		claims.put(key, data);

		String jwt = Jwts.builder()
				// Header 설정 : 토큰의 타입, 해쉬 알고리즘 정보 세팅.
				.setHeaderParam("typ", "JWT").setClaims(claims)
				// Signature 설정 : secret key를 활용한 암호화.
				.signWith(SignatureAlgorithm.HS256, this.generateKey()).compact(); // 직렬화 처리.

		return jwt;
	}

	// Signature 설정에 들어갈 key 생성.
	private byte[] generateKey() throws Exception {
		byte[] key = null;

		// charset 설정 안하면 사용자 플랫폼의 기본 인코딩 설정으로 인코딩 됨.
		key = SALT.getBytes("UTF-8");

		return key;
	}

	@Override
	public boolean checkToken(String jwt) throws Exception  {
		logger.debug("jwt: {}", jwt);
		Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);

		logger.debug("claims: {}", claims);
		return true;
	}

	@Override
	public Map<String, Object> get(String jwt) throws Exception   {

		logger.debug("jwt: {}", jwt);
		Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);

		logger.debug("claims: {}", claims);

		Map<String, Object> value = claims.getBody();
		logger.info("value : {}", value);
		return value;
	}

	@Override
	public String getUserId(String key) throws Exception {
		return (String) this.get(key).get("userId");
	}

	@Override
	public boolean saveRefreshToken(String userId, String refreshToken) throws Exception {
		return jwtMapper.saveRefreshToken(userId, refreshToken);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return jwtMapper.getRefreshToken(userId);
	}

	@Override
	public boolean deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);

		return jwtMapper.deleteRefreshToken(map);
	}

}
