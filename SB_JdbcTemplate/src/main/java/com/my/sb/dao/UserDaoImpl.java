package com.my.sb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my.sb.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> findAll() {
		String strQuery = "select * from user";
		List<User> userList = jdbcTemplate.query(strQuery, new BeanPropertyRowMapper<>(User.class));
		return userList;
	}

	@Override
	public User findById(Integer id) {
		String strQuery = "select * from user where id=?";
		User user = jdbcTemplate.queryForObject(strQuery, new BeanPropertyRowMapper<>(User.class), id);
		return user;
	}

	@Override
	public int add(User user) {
		String strQuery = "insert into user (name,age,salary,username,password) values (?,?,?,?,?)";
		Object[] args = {user.getName(), user.getAge(), user.getSalary(), user.getUsername(), user.getPassword()};
		jdbcTemplate.update(strQuery, user);
		int result = jdbcTemplate.update(strQuery, args);
		System.out.println("result : "+result);
		return result;
	}

	@Override
	public int update(User user) {
		String strQuery = "update user set name=?,age=?,salary=?,username=?,password=? where id=?";
		Object[] args = {user.getName(), user.getAge(), user.getSalary(), user.getUsername(), user.getPassword(),user.getId()};
		int result = jdbcTemplate.update(strQuery, args);
		System.out.println("result : "+result);
		return result;
	}

	@Override
	public int delete(int id) {
		String strQuery = "delete from user where id=?";
		Object[] args = {id};
		int result = jdbcTemplate.update(strQuery, args);
		return result;
	}
}
