package com.javaBrains.productMajor.serviceImpl;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaBrains.productMajor.config.Response;
import com.javaBrains.productMajor.dto.LoginDto;
import com.javaBrains.productMajor.dto.ResponseDto;
import com.javaBrains.productMajor.dto.UserDto;
import com.javaBrains.productMajor.entity.User;
import com.javaBrains.productMajor.repository.UserRepository;
import com.javaBrains.productMajor.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Response saveUser(UserDto userDto) {

		// for Encode the password
		Encoder encoder = Base64.getEncoder();
		String encoderstr = encoder.encodeToString(userDto.getPassword().getBytes());
		// System.out.println(encoderstr);

		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPhoneNo(userDto.getPhoneNo());
//		UUID uuid=UUID.randomUUID();
		user.setPassword(encoderstr);
		user.setDob(userDto.getDob());
		user.setAddress(userDto.getAddress());
		userRepository.save(user);
		return new Response("save successfully", user, HttpStatus.OK);
	}

	// LogIn method
	@Override
	public Response logInUser(LoginDto loginDto) {

		User user = userRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
		ResponseDto dto = new ResponseDto();
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setAddress(user.getAddress());
		dto.setName(user.getName());
		dto.setDob(user.getDob());
		dto.setPhoneNo(user.getPhoneNo());

		return new Response("login Successfull", dto, HttpStatus.OK);
	}

	// find user by id
	@Override
	public Response fetchUser(String name) {
		Optional<User> optionalUser = userRepository.findByName(name);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			User usr = new User();
			usr.setName(user.getName());
			usr.setAddress(user.getAddress());
			usr.setDob(user.getDob());
			usr.setEmail(user.getEmail());
			usr.setPhoneNo(user.getPhoneNo());
			usr.setId(user.getId());
			return new Response("User find successfully", usr, HttpStatus.OK);
		}
		
		return new Response("user not found for name= "+ name, HttpStatus.BAD_REQUEST);
	}

}
