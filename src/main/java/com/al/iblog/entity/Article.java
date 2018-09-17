package com.al.iblog.entity;

import java.util.Date;

public class Article {
	private Long articleId;
	private String articleName;
	private String articleDesc;
	private String articleContent;
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;
	private Integer enableStatus;
	private PersonInfo owner;
	private ArticleCategory articleCategory;
	
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getArticleDesc() {
		return articleDesc;
	}
	public void setArticleDesc(String articleDesc) {
		this.articleDesc = articleDesc;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	public PersonInfo getOwner() {
		return owner;
	}
	public void setOwner(PersonInfo owner) {
		this.owner = owner;
	}
	public ArticleCategory getArticleCategory() {
		return articleCategory;
	}
	public void setArticleCategory(ArticleCategory articleCategory) {
		this.articleCategory = articleCategory;
	}
}
