package com.zimug.bootlaunch.jpa;

import com.zimug.bootlaunch.jpa.testdb.Article;
import com.zimug.bootlaunch.jpa.testdb.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;
    
    @Test
    public void userTest() {
        Article article = articleRepository.findByAuthor("zimug");
        System.out.println(article);
    }

}
