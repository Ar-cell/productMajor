package com.javaBrains.productMajor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaBrains.productMajor.dto.ForgotPasswordDto;
import com.javaBrains.productMajor.entity.ForgotPassword;
@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, Integer>{

//	ForgotPasswordDto finfByEmail(String email);

}
