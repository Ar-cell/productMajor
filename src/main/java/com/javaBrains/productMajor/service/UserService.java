package com.javaBrains.productMajor.service;


import org.springframework.http.ResponseEntity;

import com.javaBrains.productMajor.config.Response;
import com.javaBrains.productMajor.dto.LoginDto;
import com.javaBrains.productMajor.dto.UserDto;
import com.javaBrains.productMajor.entity.User;

public interface UserService {
	
	Response saveUser(UserDto userDto);
	
	Response logInUser(LoginDto loginDto);
	
	Response fetchUser(String name);

}
