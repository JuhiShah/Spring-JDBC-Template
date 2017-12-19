package com.my.sb.service;

import java.util.List;

import com.my.sb.model.User;

public interface UserService {

	public List<User> findAll();
	public User findById(Integer id);
	public int add(User user);
	public int update(User user);
	public int delete(int id);
	
}
