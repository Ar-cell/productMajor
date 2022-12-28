package com.javaBrains.productMajor.serviceImpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.javaBrains.productMajor.config.Response;
import com.javaBrains.productMajor.dto.ForgotPasswordDto;
import com.javaBrains.productMajor.dto.UserDto;
import com.javaBrains.productMajor.entity.ForgotPassword;
import com.javaBrains.productMajor.entity.User;
import com.javaBrains.productMajor.repository.ForgotPasswordRepository;
import com.javaBrains.productMajor.repository.UserRepository;
import com.javaBrains.productMajor.service.EmailService;
import com.javaBrains.productMajor.service.ForgotPasswordService;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

	Random random = new Random(1000);
	
	@Autowired
	ForgotPasswordRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailService mailService;
	
	
//	@Override
//	public Response sendOtp(String email) {
//		User dt = userRepository.findByEmail(email);
//		if(dt != null && dt.getEmail().equalsIgnoreCase(email)) {
//			int otp = random.nextInt(99999);
//			System.out.println("otp " + otp);
//			return new Response("Otp " + otp +" send Successfully on email "+ dt.getEmail(),HttpStatus.OK);
//		}
//		return new Response("email is not valid email : {}",email,HttpStatus.OK);
//		
//	}
	
	
	@Override
	public Response sendOtp(String email) {
		
		User dt = userRepository.findByEmail(email);
//		ForgotPassword pass = new ForgotPassword();
		if(dt != null && dt.getEmail().equalsIgnoreCase(email)) {
			int otp = random.nextInt(99999);
			System.out.println("otp " + otp);
			String subject ="otp from PWD";
			String message = "otp = "+otp;
			String to =email;
			this.mailService.sendEmail(subject, message, to);
			
			return new Response(" verify Otp send Successfully on email "+ dt.getEmail(),HttpStatus.OK);
		}
		
		return new Response("email is not valid : ",email,HttpStatus.OK);
		
	}

	
	

}
