package com.levanviet.daoimpl;

import java.util.List;

import com.levanviet.dao.INewsDAO;
import com.levanviet.mapper.NewsMapper;
import com.levanviet.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryID(Long categoryIDs) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewsMapper(), categoryIDs);
	}

	@Override
	public Long saveNews(NewsModel newsModel) {
		String sql = "insert into news(title, thumbnail,categoryid) values (?, ?,?)";

		return insert(sql, newsModel.getTitle(), newsModel.getThumbnail(), newsModel.getCategoryID());
	}

	@Override
	public void updateNews(Long id) {

	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "select * from news where categoryid = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

}
