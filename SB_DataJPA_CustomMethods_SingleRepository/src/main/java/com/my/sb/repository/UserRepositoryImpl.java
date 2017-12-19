package com.my.sb.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.my.sb.model.SearchResult;

@Repository
class UserRepositoryImpl implements UserRepository{

	private String SEARCH_QUERY = "SELECT id,name from user where name= :searchTerm ORDER BY id desc";
	
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	UserRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	@Override
	public List<SearchResult> findBySearchTerm(String searchTerm) {
		Map<String, String> param = new HashMap<>();
		param.put("searchTerm", searchTerm);
		List<SearchResult> searchResults = jdbcTemplate.query(SEARCH_QUERY, param, new BeanPropertyRowMapper<>(SearchResult.class));
		return searchResults;
	}
}
