package com.al.iblog.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.al.iblog.BaseTest;
import com.al.iblog.entity.Article;
import com.al.iblog.entity.ArticleCategory;
import com.al.iblog.entity.PersonInfo;

public class ArticleDaoTest extends BaseTest{
	@Autowired
	private ArticleDao articleDao;
	
	@Test
	@Ignore
	public void testInsertArticle() {
		Article article = new Article();
		PersonInfo owner = new PersonInfo();
		ArticleCategory articleCategory = new ArticleCategory();
		owner.setUserId(1L);
		articleCategory.setArticleCategoryId(1L);
		article.setOwner(owner);
		article.setArticleCategory(articleCategory);
		article.setArticleName("测试的文章");
		article.setArticleContent("111111111111111");
		article.setArticleDesc("测试的描述");
		article.setCreateTime(new Date());
		article.setEnableStatus(1);
		int effectedNum = articleDao.insertArticle(article);
		assertEquals(1,effectedNum);
	}
	
	@Test
	public void testUpdateArticle() {
		Article article = new Article();
		article.setArticleId(1L);
		article.setArticleContent("测试内容12121212");
		article.setLastEditTime(new Date());
		int effectedNum = articleDao.updateArticle(article);
		assertEquals(1,effectedNum);
	}
}
