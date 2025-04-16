package com.example.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.UserRequest;
import com.example.practice.dto.UserResponse;
import com.example.practice.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	 
	
	@Autowired
	UserServiceImpl userService;
	
	 @PostMapping
	 public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
	     return ResponseEntity.ok(userService.createUser(request));
	 }
	
	 @GetMapping
	 public ResponseEntity<List<UserResponse>> getAllUsers() {
		 System.out.println("Call call");
	     return ResponseEntity.ok(userService.getAllUsers());
	 }
	 
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
	     return ResponseEntity.ok(userService.getUserById(id));
	 }
	
	 @PutMapping("/{id}")
	 public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
	     return ResponseEntity.ok(userService.updateUser(id, request));
	 }
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	     userService.deleteUser(id);
	     return ResponseEntity.noContent().build();
	 }
	 
}
