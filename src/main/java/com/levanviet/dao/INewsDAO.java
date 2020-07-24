package com.levanviet.dao;

import java.util.List;

import com.levanviet.model.NewsModel;

public interface INewsDAO extends GenericDAO<NewsModel> {
	List<NewsModel> findByCategoryID(Long categoryIDs);

	Long saveNews(NewsModel newsModel);

	void updateNews(Long id);

	NewsModel findOne(Long id);
}
