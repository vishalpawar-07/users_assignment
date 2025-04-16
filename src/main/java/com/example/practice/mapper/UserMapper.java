package com.example.practice.mapper;

import com.example.practice.dto.UserRequest;
import com.example.practice.dto.UserResponse;
import com.example.practice.entity.User;

public class UserMapper {

	public static User toEntity(UserRequest request) {
	    User user = new User();
	    user.setFirstName(request.getFirstName());
	    user.setLastName(request.getLastName());
	    user.setEmail(request.getEmail());
	    user.setPhoneNumber(request.getPhoneNumber());
	    return user;
	}


public static UserResponse toResponse(User user) {
  UserResponse res = new UserResponse();
  res.setId(user.getId());
  res.setFirstName(user.getFirstName());
  res.setLastName(user.getLastName());
  res.setEmail(user.getEmail());
  res.setPhoneNumber(user.getPhoneNumber());
  res.setCreatedAt(user.getCreatedAt());
  res.setUpdatedAt(user.getUpdatedAt());
  return res;
}
}
