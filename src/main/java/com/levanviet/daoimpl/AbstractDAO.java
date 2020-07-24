package com.levanviet.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.levanviet.dao.GenericDAO;
import com.levanviet.mapper.IRowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/webtintuc";
			String user = "root";
			String password = "1234";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}

	@Override
	public <T> List<T> query(String sql, IRowMapper<T> pper, Object... paramaters) {
		List<T> lstresult = new ArrayList<>();
		Connection conn = null;
		PreparedStatement prepare = null;
		ResultSet result = null;
		try {
			conn = getConnection();
			prepare = conn.prepareStatement(sql);
			setParamater(prepare, paramaters);
			result = prepare.executeQuery();
			while (result.next()) {
				lstresult.add(pper.mapRow(result));
			}
			return lstresult;
		} catch (SQLException e) {
			return null;
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

	private void setParamater(PreparedStatement prepare, Object... paramaters) {

		try {
			for (int i = 0; i < paramaters.length; i++) {
				Object paramater = paramaters[i];
				int index = i + 1;
				if (paramater instanceof Long) {
					prepare.setLong(index, (Long) paramater);
				} else if (paramater instanceof Integer) {
					prepare.setInt(index, (Integer) paramater);
				} else if (paramater instanceof String) {
					prepare.setString(index, (String) paramater);
				} else if (paramater instanceof Double) {
					prepare.setDouble(index, (Double) paramater);
				} else if (paramater instanceof Float) {
					prepare.setFloat(index, (Float) paramater);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(String sql, Object... paramaters) {
		Connection conn = null;
		PreparedStatement statement = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			setParamater(statement, paramaters);
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Long insert(String sql, Object... paramaters) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Long id = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParamater(statement, paramaters);
			statement.executeUpdate();
			result = statement.getGeneratedKeys();
			if (result.next()) {
				id = result.getLong(1);
			}
			conn.commit();
			return id;

		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					return null;
				}
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (result != null) {
					result.close();
				}

			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}
}
