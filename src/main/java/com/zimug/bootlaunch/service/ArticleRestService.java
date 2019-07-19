package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.model.Article;

import java.util.List;

public interface ArticleRestService {

    public Article saveArticle(Article article);

    public void deleteArticle(Long id);

    public void updateArticle(Article article);

    public Article getArticle(Long id);

    public List<Article> getAll();
}

