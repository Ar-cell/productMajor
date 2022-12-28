package com.javaBrains.productMajor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaBrains.productMajor.config.Response;
import com.javaBrains.productMajor.dto.LoginDto;
import com.javaBrains.productMajor.dto.UserDto;
import com.javaBrains.productMajor.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	public UserService userService;
	
	@PostMapping("signUp")
	public Response saveUser(@RequestBody UserDto userDto) {
		return userService.saveUser(userDto);
	}
	
	@PostMapping("/login")
	public Response logInUser(@RequestBody LoginDto loginDto) {
		return userService.logInUser(loginDto);
	}
	
	@GetMapping("/search/{name}")
	public Response fetchUser(@PathVariable String name) {
		return userService.fetchUser(name);
	} 
}
