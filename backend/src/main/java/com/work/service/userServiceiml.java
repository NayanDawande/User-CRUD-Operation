package com.work.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.work.dao.userRepository;
import com.work.entity.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class userServiceiml implements userService {

	userRepository userRepo;

	@Override
	public List<User> getAll() {

		return userRepo.findAll();
	}

	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User modify(int id, User user) {

		User exUser = new User();
		exUser.setId(id);
		exUser.setFirstName(user.getFirstName());
		exUser.setLastName(user.getLastName());
		exUser.setEmail(user.getEmail());

		return add(exUser);

	}

	@Override
	public void delete(int id) {
		
		 userRepo.deleteById(id);
	}

	@Override
	public User getSingleUser(int id) {

		return userRepo.findById(id).get();

	}

}
