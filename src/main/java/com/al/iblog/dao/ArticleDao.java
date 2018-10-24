package com.al.iblog.dao;

import com.al.iblog.entity.Article;

public interface ArticleDao {
	/**
	 * 新增文章
	 * @param article
	 * @return
	 */
	int insertArticle(Article article);
	/**
	 * 更新文章信息
	 * @param article
	 * @return
	 */
	int updateArticle(Article article);
	
	Article queryByArticleId(long articleId);
}
