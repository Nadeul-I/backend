package com.ssafy.user.model.service;

import com.ssafy.user.model.UserDto;

public interface UserService {

	UserDto signIn(UserDto userDto);

	UserDto userInfo(String userId);

	boolean idDupCheck(String userId);

	String findPw(String userId, String userEmail);

	boolean signUp(UserDto userDto);

	boolean withdraw(String userId);

	boolean userModify(UserDto userDto);

}
