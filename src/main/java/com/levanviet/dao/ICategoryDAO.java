package com.levanviet.dao;

import java.util.List;

import com.levanviet.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
}
