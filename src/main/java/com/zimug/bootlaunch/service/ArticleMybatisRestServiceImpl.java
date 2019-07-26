package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.generator.testdb.Article;
import com.zimug.bootlaunch.generator.testdb.ArticleMapper;
import com.zimug.bootlaunch.model.ArticleVO;
import com.zimug.bootlaunch.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;

import org.dozer.Mapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService{

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;


    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "article",key = "#article.getId()"),
                    @CacheEvict(value = "articleAll",allEntries = true)
            }
    )
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.insert(articlePO);

        //TODO 把readers村到数据库里面
        article.setId(articlePO.getId());
        return article;
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "article",key = "#id"),
                    @CacheEvict(value = "articleAll",allEntries = true)
            }
    )
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "article",key = "#article.getId()"),
                    @CacheEvict(value = "articleAll",allEntries = true)
            }
    )
    public ArticleVO updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
        return article;
    }

    @Override
    @Cacheable(value="article",key = "#id",condition = "#id > 1")
    public ArticleVO getArticle(Long id) {
        //TODO 把读者信息查询出来赋值给ArticleVo
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }

    @Override
    @Cacheable(value="articleAll")
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);

    }
}
