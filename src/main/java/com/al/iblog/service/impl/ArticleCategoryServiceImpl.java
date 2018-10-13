package com.al.iblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al.iblog.dao.ArticleCategoryDao;
import com.al.iblog.entity.ArticleCategory;
import com.al.iblog.service.ArticleCategoryService;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService{
	@Autowired
	private ArticleCategoryDao articleCategoryDao;

	@Override
	public List<ArticleCategory> getArticleCategoryList(ArticleCategory articleCategoryCondition) {
		return articleCategoryDao.queryArticleCategory(articleCategoryCondition);
	}

}
