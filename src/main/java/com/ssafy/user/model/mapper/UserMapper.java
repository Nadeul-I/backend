package com.ssafy.user.model.mapper;

import org.springframework.stereotype.Repository;

import com.ssafy.user.model.UserDto;

@Repository
public interface UserMapper {

	UserDto signIn(UserDto userDto);

	boolean idCheck(String userId);

	boolean signUp(UserDto userDto);

	UserDto view(String userId);

	boolean withdraw(UserDto userDto);

	boolean modify(UserDto userDto);

	String findPw(String userId, String userEmail);

	int idDupCheck(String userId);
}
