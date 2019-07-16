package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestService {

    public String saveArticle( Article article) {

        log.info("saveArticle：{}",article);

        return  "测试";
    }
}
