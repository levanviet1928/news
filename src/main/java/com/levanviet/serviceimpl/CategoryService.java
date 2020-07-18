package com.levanviet.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import com.levanviet.daoimpl.CategoryDAO;
import com.levanviet.model.CategoryModel;
import com.levanviet.service.ICategoryService;

public class CategoryService implements ICategoryService {
	@Inject
	private CategoryDAO categoryDao;
//	public CategoryService() {
//		categoryDao = new CategoryDAO();
//	}

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

}
