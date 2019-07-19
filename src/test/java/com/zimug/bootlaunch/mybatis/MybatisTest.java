package com.zimug.bootlaunch.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zimug.bootlaunch.generator.testdb.Article;
import com.zimug.bootlaunch.generator.testdb.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Resource
    ArticleMapper articleMapper;

    @Test
    public void testPageHelper(){
        // 只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页!!!!
        PageHelper.startPage(1, 2);
        List<Article> articles = articleMapper.selectByExample(null);
        PageInfo<Article> page = PageInfo.of(articles);
        System.out.println(page);
    }
}