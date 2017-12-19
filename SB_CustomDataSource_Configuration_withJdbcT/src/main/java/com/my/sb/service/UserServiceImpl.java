package com.my.sb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.dao.UserDao;
import com.my.sb.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Transactional
	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Transactional
	@Override
	public int add(User user) {
		return userDao.add(user);
	}

	@Transactional
	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Transactional
	@Override
	public int delete(int id) {
		return userDao.delete(id);
	}

}
