package com.al.iblog.service;

import com.al.iblog.dto.ArticleExecution;
import com.al.iblog.entity.Article;
import com.al.iblog.exceptions.ArticleOperationException;


public interface ArticleService {
	/**
	 * 根据articleCondition分页返回相应文章列表
	 * @param articleCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	//public ArticleExecution getArticleList(Article articleCondition, int pageIndex, int pageSize);
	/**
	 * 通过文章Id获取文章信息
	 * @param articleId
	 * @return
	 */
	Article getByArticleId(long articleId);
	/**
	 * 更新文章信息
	 * @param article
	 * @return
	 * @throws ArticleOperationException
	 */
	ArticleExecution modifyArticle(Article article) throws ArticleOperationException;
	/**
	 * 添加文章
	 * @param article
	 * @return
	 * @throws ArticleOperationException
	 */
	ArticleExecution addArticle(Article article) throws ArticleOperationException;
}
