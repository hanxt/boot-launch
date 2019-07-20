package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.generator.testdb.Article;
import com.zimug.bootlaunch.generator.testdb.ArticleMapper;
import com.zimug.bootlaunch.generator.testdb2.Message;
import com.zimug.bootlaunch.generator.testdb2.MessageMapper;
import com.zimug.bootlaunch.model.ArticleVO;
import com.zimug.bootlaunch.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService{

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private MessageMapper messageMapper;


    @Override
    @Transactional
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.insert(articlePO);

        Message message = new Message();
        message.setName("curry");
        message.setContent("厉害");
        messageMapper.insert(message);

        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);

    }
}
