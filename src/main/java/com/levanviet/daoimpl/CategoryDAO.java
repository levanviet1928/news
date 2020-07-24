package com.levanviet.daoimpl;

import java.util.List;

import com.levanviet.dao.ICategoryDAO;
import com.levanviet.mapper.CategoryMapper;
import com.levanviet.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}
}
