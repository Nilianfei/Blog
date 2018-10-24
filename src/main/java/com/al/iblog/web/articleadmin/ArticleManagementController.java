package com.al.iblog.web.articleadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.al.iblog.dto.ArticleExecution;
import com.al.iblog.entity.Article;
import com.al.iblog.entity.ArticleCategory;
import com.al.iblog.entity.PersonInfo;
import com.al.iblog.enums.ArticleStateEnum;
import com.al.iblog.exceptions.ArticleOperationException;
import com.al.iblog.service.ArticleCategoryService;
import com.al.iblog.service.ArticleService;
import com.al.iblog.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/articleadmin")
public class ArticleManagementController {
	@Autowired
	ArticleService articleService;
	@Autowired
	ArticleCategoryService articleCategoryService;
	
	@RequestMapping(value = "/getarticlebyid", method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> getArticleById(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Long articleId = HttpServletRequestUtil.getLong(request, "articleId");
		if(articleId > -1) {
			try{
				Article article = articleService.getByArticleId(articleId);
				modelMap.put("article", article);
				modelMap.put("success", true);
			} catch(Exception e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty articleId");
		}
		return modelMap;
	}
	
	@RequestMapping(value = "/getarticleinitinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getArticleInitInfo() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>(); 
		try{
			articleCategoryList = articleCategoryService.getArticleCategoryList(new ArticleCategory());
			modelMap.put("articleCategoryList", articleCategoryList);
			modelMap.put("success", true);
		} catch(Exception e){
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}
		return modelMap;
	}
	
	@RequestMapping(value = "/addarticle", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addArticle(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		// 1.接收并转化相应的参数
//		String articleStr = HttpServletRequestUtil.getString(request, "articleStr");
		Map<String, String> params = HttpServletRequestUtil.getParams(request);
		String articleStr = params.get("articleStr");
		ObjectMapper mapper = new ObjectMapper();
		Article article = null;
		try {
			article = mapper.readValue(articleStr, Article.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		// 2.添加文章
		if (article != null) {
			PersonInfo owner = (PersonInfo) request.getSession().getAttribute("user");
			article.setOwner(owner);
			ArticleExecution ae;
			try {
				ae = articleService.addArticle(article);
				if (ae.getState() == ArticleStateEnum.CHECK.getState()) {
					modelMap.put("success", true);
					// 该用户可以操作的文章列表
					@SuppressWarnings("unchecked")
					List<Article> articleList = (List<Article>) request.getSession().getAttribute("articleList");
					if (articleList == null || articleList.size() == 0) {
						articleList = new ArrayList<Article>();
					}
					articleList.add(ae.getArticle());
					request.getSession().setAttribute("articleList", articleList);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", ae.getStateInfo());
				}
			} catch (ArticleOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入文章信息");
			return modelMap;
		}
	}
	
	@RequestMapping(value = "/modifyarticle", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> modifyArticle(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		// 1.接收并转化相应的参数
//		String articleStr = HttpServletRequestUtil.getString(request, "articleStr");
		Map<String, String> params = HttpServletRequestUtil.getParams(request);
		String articleStr = params.get("articleStr");
		ObjectMapper mapper = new ObjectMapper();
		Article article = null;
		try {
			article = mapper.readValue(articleStr, Article.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		// 2.添加文章
		if (article != null) {
			ArticleExecution ae;
			try {
				ae = articleService.modifyArticle(article);
				if (ae.getState() == ArticleStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
					// 该用户可以操作的文章列表
//					@SuppressWarnings("unchecked")
//					List<Article> articleList = (List<Article>) request.getSession().getAttribute("articleList");
//					if (articleList == null || articleList.size() == 0) {
//						articleList = new ArrayList<Article>();
//					}
//					articleList.add(ae.getArticle());
//					request.getSession().setAttribute("articleList", articleList);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", ae.getStateInfo());
				}
			} catch (ArticleOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入文章Id");
			return modelMap;
		}
	}
}
