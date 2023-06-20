package com.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.work.entity.User;
import com.work.service.userService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class userController {

	@Autowired
	userService userService;

	List<User> userList;

	@PostMapping("/add")
	public ResponseEntity<User> add(@RequestBody User user) {
		User user1 = userService.add(user);
		return new ResponseEntity<User>(user1, HttpStatus.ACCEPTED);

	}

	@PutMapping("/api/{id}")
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable int id) {

		User exUser = userService.modify(id, user);

		return new ResponseEntity<User>(exUser, HttpStatus.OK);
	}

	@DeleteMapping("api/delete/{id}")
	public ResponseEntity<String> remove(@PathVariable int id) {

		userService.delete(id);

		return new ResponseEntity<String>("User Record has been deleted successfully", HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll() {

		List<User> user = userService.getAll();

		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@RequestMapping("2")
	@ResponseBody
	public ResponseEntity<User> getSingle(@PathVariable int id) {
		User user = userService.getSingleUser(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

}
