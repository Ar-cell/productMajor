package com.javaBrains.productMajor.controller;


import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaBrains.productMajor.config.Response;
import com.javaBrains.productMajor.service.EmailService;
import com.javaBrains.productMajor.service.ForgotPasswordService;

@RestController
public class ForgetController {
	
	Random random = new Random(1000);
	
	@Autowired
	private ForgotPasswordService service;

	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/forget")
	public String openEmailForm() {
		return "forget_email_form";
	}
	
	@PostMapping("/send-otp")
	public Response sendOtp(@RequestParam String emailId) {
		return service.sendOtp(emailId);	
	}
	
	// implementaion here only
	@PostMapping("/send")
	public void Otp(@RequestParam String emailId) {
		System.out.println("Email "+ emailId);
		int otp = random.nextInt(99999);
		System.out.println("otp " + otp);
		String subject ="otp from PWD to reset your password";
		String message = "otp = "+otp;
		String to =emailId;
		emailService.sendEmail(subject, message, to);
		System.out.println("otp send successfully on email "+emailId);
		
	}
	
}
