package com.lxj.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lxj.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	@Override
	public <T> void crud(String sql,Object...params) {
		jdbcTemplate.update(sql, params);
	}
	@Override
	public List<?> getpageList(String sql, Object... params) {
		List<?> list = jdbcTemplate.queryForList(sql, params);
		return list;
	}
	@SuppressWarnings("deprecation")
	@Override
	public int getCount(String sql) {
		return jdbcTemplate.queryForInt(sql);
	}
	
    
	
}
