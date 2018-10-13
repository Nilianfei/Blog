package com.al.iblog.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.al.iblog.BaseTest;
import com.al.iblog.entity.ArticleCategory;

public class ArticleCategoryDaoTest extends BaseTest{
	@Autowired
	ArticleCategoryDao articleCategoryDao;
	
	@Test
	public void testQueryShopCategory() {
		List<ArticleCategory> articleCategoryList = articleCategoryDao.queryArticleCategory(null);
		System.out.println(articleCategoryList.size());
	}
}
