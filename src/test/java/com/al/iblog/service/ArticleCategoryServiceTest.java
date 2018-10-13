package com.al.iblog.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.al.iblog.BaseTest;
import com.al.iblog.entity.ArticleCategory;

public class ArticleCategoryServiceTest extends BaseTest{
	@Autowired
	private ArticleCategoryService articleCategoryService;

	@Test
	public void testGetArticleCategoryList() {
		List<ArticleCategory> categoryList = articleCategoryService.getArticleCategoryList(null);
		System.out.println(categoryList.get(0).getArticleCategoryName());
		ArticleCategory articleCategoryCondition = new ArticleCategory();
		ArticleCategory parent = new ArticleCategory();
		parent.setArticleCategoryId(2L);
		articleCategoryCondition.setParent(parent);
		categoryList = articleCategoryService.getArticleCategoryList(articleCategoryCondition);
		System.out.println(categoryList.get(0).getArticleCategoryName());
	}
}
