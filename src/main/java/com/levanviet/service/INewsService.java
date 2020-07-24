package com.levanviet.service;

import java.util.List;

import com.levanviet.model.NewsModel;

public interface INewsService {
	List<NewsModel> findByCategoryID(Long categoryID);

	NewsModel saveNews(NewsModel newsModel);
}
