package pl.home.spring.bean;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.home.spring.database.primary.dao.IArticleDAO;
import pl.home.spring.database.primary.entity.Article;
import pl.home.spring.database.secondary.dao.SecondaryArticleDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ArticleService {
	private static Logger logger = LoggerFactory.getLogger(ArticleService.class);
	
	@Autowired
	private IArticleDAO articleDAO;
	@Autowired
	private SecondaryArticleDAO secondaryArticleDAO;
	
	public List<Article> getAllArticles() {
		try {
			return articleDAO.getAllArticles();
		} catch (Exception e) {
			logger.error("Error when execute getAllArticles: " + e);
			return new ArrayList<Article>();
		}
	}
	
	public List<pl.home.spring.database.secondary.entity.Article> getSecondaryAllArticles() {
		try {
			return secondaryArticleDAO.getAllArticles();
		} catch (Exception e) {
			logger.error("Error when execute getAllArticles: " + e);
			return new ArrayList<pl.home.spring.database.secondary.entity.Article>();
		}
	}
}
