package com.al.iblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.al.iblog.entity.ArticleCategory;

public interface ArticleCategoryDao {
	List<ArticleCategory> queryArticleCategory(@Param("articleCategoryCondition") ArticleCategory articleCategoryCondition);
}
