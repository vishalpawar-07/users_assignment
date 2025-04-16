package com.example.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
