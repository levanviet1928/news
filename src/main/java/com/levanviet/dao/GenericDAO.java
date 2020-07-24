package com.levanviet.dao;

import java.util.List;

import com.levanviet.mapper.IRowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, IRowMapper<T> pper, Object... paramaters);

	void update(String sql, Object... paramaters);

	Long insert(String sql, Object... paramaters);
}
