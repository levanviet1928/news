package com.levanviet.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.levanviet.model.NewsModel;

public class NewsMapper implements IRowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet result) {

		try {
			NewsModel news = new NewsModel();
			news.setId(result.getLong("id"));
			news.setTitle(result.getString("title"));
			news.setThumbnail(result.getString("thumbnail"));
			news.setCategoryID(result.getLong("categoryid"));
			return news;
		} catch (SQLException e) {
			return null;
		}

	}

}
