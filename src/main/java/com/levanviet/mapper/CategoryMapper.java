package com.levanviet.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.levanviet.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet result) {

		CategoryModel category = new CategoryModel();
		try {
			category.setId(result.getLong("id"));
			category.setName(result.getString("name"));
			category.setCode(result.getString("code"));
			return category;
		} catch (SQLException e) {
			return null;
		}
	}

}
