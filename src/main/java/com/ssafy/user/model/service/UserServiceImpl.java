package com.ssafy.user.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public UserDto signIn(UserDto userDto) {
		return userMapper.signIn(userDto);
	}

	@Override
	public UserDto userInfo(String userId) {
		return userMapper.view(userId);
	}

	@Override
	public boolean idDupCheck(String userId) {
		if(userMapper.idDupCheck(userId) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String findPw(String userId, String userEmail) {
		return userMapper.findPw(userId, userEmail);
	}

	@Override
	public boolean signUp(UserDto userDto) {
		return userMapper.signUp(userDto);
	}

	@Override
	public boolean withdraw(UserDto userDto) {
		return userMapper.withdraw(userDto);
	}

	@Override
	public boolean userModify(UserDto userDto) {
		return userMapper.modify(userDto);
	}
	
}
