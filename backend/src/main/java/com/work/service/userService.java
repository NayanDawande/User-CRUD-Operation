package com.work.service;

import java.util.List;

import com.work.entity.User;

public interface userService {

	public List<User> getAll();
	
	public User add(User user);
	
	public User modify(int id, User user);
	
	public void delete(int id );
	
	public User getSingleUser(int id);
	
	
}
