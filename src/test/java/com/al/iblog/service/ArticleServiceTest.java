package com.al.iblog.service;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.al.iblog.BaseTest;
import com.al.iblog.dto.ArticleExecution;
import com.al.iblog.entity.Article;
import com.al.iblog.entity.ArticleCategory;
import com.al.iblog.entity.PersonInfo;
import com.al.iblog.enums.ArticleStateEnum;
import com.al.iblog.exceptions.ArticleOperationException;

public class ArticleServiceTest extends BaseTest {
	
	@Autowired
	private ArticleService articleService;

	@Test
	public void testModifyShop() throws ArticleOperationException {
		Article article = new Article();
		article.setArticleId(1L);
		article.setArticleName("修改过后的文章名字");
		ArticleExecution articleExecution = articleService.modifyArticle(article);
	}
	
	@Test
	@Ignore
	public void testAddArticle() throws ArticleOperationException{
		Article article = new Article();
		PersonInfo owner = new PersonInfo();
		ArticleCategory articleCategory = new ArticleCategory();
		owner.setUserId(1L);
		articleCategory.setArticleCategoryId(1L);
		article.setOwner(owner);
		article.setArticleCategory(articleCategory);
		article.setArticleContent("test2");
		article.setArticleDesc("test2");
		article.setArticleName("test2");
		ArticleExecution ae = articleService.addArticle(article);
		assertEquals(ArticleStateEnum.CHECK.getState(), ae.getState());
	}
}
