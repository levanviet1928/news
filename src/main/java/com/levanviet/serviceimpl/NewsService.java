package com.levanviet.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import com.levanviet.daoimpl.NewsDAO;
import com.levanviet.model.NewsModel;
import com.levanviet.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private NewsDAO newsDAO;

	@Override
	public List<NewsModel> findByCategoryID(Long categoryID) {
		return newsDAO.findByCategoryID(categoryID);
	}

	@Override
	public NewsModel saveNews(NewsModel newsModel) {
		Long newsID = newsDAO.saveNews(newsModel);
		return newsDAO.findOne(newsID);
	}

}
