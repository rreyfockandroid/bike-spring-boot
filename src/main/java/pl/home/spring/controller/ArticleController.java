package pl.home.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.home.spring.bean.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/article/all")
	public String articles(Map<String, Object> model) {
		model.put("allArticles", articleService.getAllArticles());
		model.put("allSecondaryArticles", articleService.getSecondaryAllArticles());
		return "article";
	}
}
