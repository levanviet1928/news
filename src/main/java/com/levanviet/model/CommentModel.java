package com.levanviet.model;

public class CommentModel  extends AbstractClassModel{
	private Long userID;
	private Long newsID;
	private String content;
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Long getNewsID() {
		return newsID;
	}
	public void setNewsID(Long newsID) {
		this.newsID = newsID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
