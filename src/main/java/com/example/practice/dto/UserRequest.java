package com.example.practice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
 @NotBlank
 private String firstName;

 @NotBlank
 private String lastName;

 @Email
 @NotBlank
 private String email;

 private String phoneNumber;

public UserRequest() {
	super();
	// TODO Auto-generated constructor stub
}

public UserRequest(@NotBlank String firstName, @NotBlank String lastName, @Email @NotBlank String email,
		String phoneNumber) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phoneNumber = phoneNumber;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
 
 
}
