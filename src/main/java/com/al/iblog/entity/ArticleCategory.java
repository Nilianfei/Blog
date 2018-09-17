package com.al.iblog.entity;

import java.util.Date;

public class ArticleCategory {
	private Long articleCategoryId;
	private String articleCategoryName;
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;
	private ArticleCategory parent;
	public Long getArticleCategoryId() {
		return articleCategoryId;
	}
	public void setArticleCategoryId(Long articleCategoryId) {
		this.articleCategoryId = articleCategoryId;
	}
	public String getArticleCategoryName() {
		return articleCategoryName;
	}
	public void setArticleCategoryName(String articleCategoryName) {
		this.articleCategoryName = articleCategoryName;
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
	public ArticleCategory getParent() {
		return parent;
	}
	public void setParent(ArticleCategory parent) {
		this.parent = parent;
	}
	
	
}
