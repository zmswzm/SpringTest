package com.lxj.dao;

import java.util.List;

public interface BaseDao {
  public <T> void crud(String sql,Object...params);
  public List<?> getpageList(String sql,Object...params);
  public int getCount(String sql);
}
