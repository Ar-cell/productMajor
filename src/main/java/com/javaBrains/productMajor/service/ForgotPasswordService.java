package com.javaBrains.productMajor.service;

import com.javaBrains.productMajor.config.Response;
import com.javaBrains.productMajor.dto.ForgotPasswordDto;
import com.javaBrains.productMajor.dto.UserDto;

public interface ForgotPasswordService {
	
	public Response sendOtp(String email);
}
