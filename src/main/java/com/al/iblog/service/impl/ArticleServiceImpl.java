package com.al.iblog.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al.iblog.dao.ArticleDao;
import com.al.iblog.dto.ArticleExecution;
import com.al.iblog.entity.Article;
import com.al.iblog.enums.ArticleStateEnum;
import com.al.iblog.exceptions.ArticleOperationException;
import com.al.iblog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;

	@Override
	public ArticleExecution addArticle(Article article) throws ArticleOperationException {
		// 空值判断
		if (article == null) {
			return new ArticleExecution(ArticleStateEnum.NULL_ARTICLE);
		}
		try {
			// 给店铺信息赋初始值
			article.setEnableStatus(0);
			article.setCreateTime(new Date());
			article.setLastEditTime(new Date());
			// 添加店铺信息
			int effectedNum = articleDao.insertArticle(article);
			if (effectedNum <= 0) {
				throw new ArticleOperationException("文章创建失败");
			}
		} catch (Exception e) {
			throw new ArticleOperationException("addArticle error:" + e.getMessage());
		}
		return new ArticleExecution(ArticleStateEnum.CHECK, article);
	}

	@Override
	public Article getByArticleId(long articleId) {
		return articleDao.queryByArticleId(articleId);
	}

	@Override
	public ArticleExecution modifyArticle(Article article) throws ArticleOperationException {
		try{
			article.setLastEditTime(new Date());
		int effectedNum = articleDao.updateArticle(article);
		if(effectedNum <= 0) {
			return new ArticleExecution(ArticleStateEnum.INNER_ERROR);
		} else{
			article = articleDao.queryByArticleId(article.getArticleId());
			return new ArticleExecution(ArticleStateEnum.SUCCESS, article);
		}} catch(Exception e){
			throw new ArticleOperationException("modifyArticle error:"+ e.getMessage());
		}
	}

}
