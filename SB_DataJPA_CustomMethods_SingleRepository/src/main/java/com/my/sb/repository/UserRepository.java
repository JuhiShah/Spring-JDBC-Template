package com.my.sb.repository;

import java.util.List;

import com.my.sb.model.SearchResult;


public interface UserRepository {

	List<SearchResult> findBySearchTerm(String searchTerm); 
}