package com.lxj.dao;

public interface BaseDao {
  public <T> void add(String sql,Object...params);
}
