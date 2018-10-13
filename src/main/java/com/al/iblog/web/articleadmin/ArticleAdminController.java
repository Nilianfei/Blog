package com.al.iblog.web.articleadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="articleadmin",method={RequestMethod.GET})
public class ArticleAdminController {
	@RequestMapping(value = "/articleoperation")
	public String articleOperation(){
		return "article/articleoperation";
	}
}
