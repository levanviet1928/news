package com.levanviet.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.levanviet.dao.ICategoryDAO;
import com.levanviet.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:mysql://localhost:3306/webtintuc";
			String user = "root";
			String password = "1234";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> lstCate = new ArrayList<>();
		Connection conn = getConnection();
		PreparedStatement prepare = null;
		ResultSet result = null;
		if (conn != null) {
			try {
				String sql = "SELECT * FROM category";
				prepare = conn.prepareStatement(sql);
				result = prepare.executeQuery();
				while (result.next()) {
					CategoryModel cate = new CategoryModel();
					cate.setId(result.getLong("id"));
					cate.setCode(result.getString("code"));
					cate.setName(result.getString("name"));
					lstCate.add(cate);
					return lstCate;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
					if (prepare != null) {
						prepare.close();
					}
					if (result != null) {
						result.close();
					}
				} catch (SQLException e) {
					return null;
				}

			}
		}
		return null;
	}
}
