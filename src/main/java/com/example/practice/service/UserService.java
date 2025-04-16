package com.example.practice.service;

import java.util.List;

import com.example.practice.dto.UserRequest;
import com.example.practice.dto.UserResponse;


public interface UserService {

	 UserResponse createUser(UserRequest request);
	 List<UserResponse> getAllUsers();
	 UserResponse getUserById(Long id);
	 UserResponse updateUser(Long id, UserRequest request);
	 void deleteUser(Long id);
}
