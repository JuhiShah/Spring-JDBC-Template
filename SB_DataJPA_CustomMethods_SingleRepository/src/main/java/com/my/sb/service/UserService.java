package com.my.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.model.SearchResult;
import com.my.sb.repository.UserRepository;

@Service
public class UserService  {

	@Autowired
	UserRepository repository;
	
	public List<SearchResult> findBySearchTerm(String searchTerm) {
		return repository.findBySearchTerm(searchTerm);
	}
}