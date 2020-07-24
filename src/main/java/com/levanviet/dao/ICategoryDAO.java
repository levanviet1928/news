package com.levanviet.dao;

import java.util.List;

import com.levanviet.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
}
