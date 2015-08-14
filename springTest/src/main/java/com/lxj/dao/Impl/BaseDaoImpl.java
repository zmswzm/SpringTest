package com.lxj.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lxj.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;  //都不需要setter?
	@Override
	public <T> void add(String sql,Object...params) {
		jdbcTemplate.update(sql, params);

	}

}
