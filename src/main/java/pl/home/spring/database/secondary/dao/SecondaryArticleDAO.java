package pl.home.spring.database.secondary.dao;

import java.util.List;

import pl.home.spring.database.secondary.entity.Article;

public interface SecondaryArticleDAO {
    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category);
} 