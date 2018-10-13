package com.al.iblog.dto;

import java.util.List;

import com.al.iblog.entity.Article;
import com.al.iblog.enums.ArticleStateEnum;

public class ArticleExecution {
	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	// 文章数量
	private int count;

	// 操作的article
	private Article article;

	private List<Article> articleList;

	public ArticleExecution() {

	}

	// 文章操作失败的时候使用的构造器
	public ArticleExecution(ArticleStateEnum stateEnum) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
		}

	// 文章操作成功的时候使用的构造器
	public ArticleExecution(ArticleStateEnum stateEnum, Article article) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.article = article;
		}

	// 文章操作成功的时候使用的构造器
	public ArticleExecution(ArticleStateEnum stateEnum, List<Article> articleList) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.articleList = articleList;
		}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
}
