package com.javaBrains.productMajor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaBrains.productMajor.dto.ForgotPasswordDto;
import com.javaBrains.productMajor.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmailAndPassword(String email, String password);



	User findByEmail(String email);



	Optional<User> findByName(String name);

}
