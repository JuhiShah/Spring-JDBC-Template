package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.User;
import com.my.sb.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public User findById(@PathVariable("id")Integer id){
		return userService.findById(id);
	}
	
	@PostMapping("/add")
	public int add(@RequestBody User user){
		System.out.println(user.getName());
		return userService.add(user);
	}
	
	@PostMapping("/update")
	public int update(@RequestBody User user){
		System.out.println(user.getName());
		return userService.update(user);
	}
	
	@GetMapping("/delete/{id}")
	public int delete(@PathVariable("id")Integer id){
		return userService.delete(id);
	}
}
