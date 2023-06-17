package com.work.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.entity.User;

public interface userRepository extends JpaRepository<User, Integer>{

}
