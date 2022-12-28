package com.javaBrains.productMajor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usr_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Ëmail")
	private String email;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="PhoneNo")
	private String phoneNo;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="DOB")
	private String dob;
}
