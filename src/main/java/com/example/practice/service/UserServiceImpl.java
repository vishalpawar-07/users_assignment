package com.example.practice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.dto.UserRequest;
import com.example.practice.dto.UserResponse;
import com.example.practice.entity.User;
import com.example.practice.exception.ResourceNotFoundException;
import com.example.practice.mapper.UserMapper;
import com.example.practice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

 @Autowired
 UserRepository userRepository;
 
 @Override
 public UserResponse createUser(UserRequest request) {
     User user = UserMapper.toEntity(request);
     return UserMapper.toResponse(userRepository.save(user));
 }

 @Override
 public List<UserResponse> getAllUsers() {
	 System.out.println("Called");
     return userRepository.findAll()
             .stream()
             .map(UserMapper::toResponse)
             .collect(Collectors.toList());
 }

 @Override
 public UserResponse getUserById(Long id) {
     User user = userRepository.findById(id).orElseThrow(() ->
             new ResourceNotFoundException("User not found with ID: " + id));
     return UserMapper.toResponse(user);
 }

 @Override
 public UserResponse updateUser(Long id, UserRequest request) {
     User existing = userRepository.findById(id).orElseThrow(() ->
             new ResourceNotFoundException("User not found with ID: " + id));
     existing.setFirstName(request.getFirstName());
     existing.setLastName(request.getLastName());
     existing.setEmail(request.getEmail());
     existing.setPhoneNumber(request.getPhoneNumber());
     return UserMapper.toResponse(userRepository.save(existing));
 }

 @Override
 public void deleteUser(Long id) {
     User user = userRepository.findById(id).orElseThrow(() ->
             new ResourceNotFoundException("User not found with ID: " + id));
     userRepository.delete(user);
 }
}