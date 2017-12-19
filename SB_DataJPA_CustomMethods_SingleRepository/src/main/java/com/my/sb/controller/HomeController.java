package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.SearchResult;
import com.my.sb.service.UserService;


@RestController
public class HomeController {

	@Autowired
	UserService service;
	
	@RequestMapping("/findBySearchTerm/{name}")
	public List<SearchResult> findBySearchTerm(@PathVariable("name") String searchTerm) {
		return service.findBySearchTerm(searchTerm);
	}
}
