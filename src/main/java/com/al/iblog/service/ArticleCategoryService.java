package com.al.iblog.service;

import java.util.List;

import com.al.iblog.entity.ArticleCategory;

public interface ArticleCategoryService {
	List<ArticleCategory> getArticleCategoryList(ArticleCategory articleCategoryCondition);
}
