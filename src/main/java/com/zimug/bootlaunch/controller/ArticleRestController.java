package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.model.AjaxResponse;
import com.zimug.bootlaunch.model.ArticleVO;
import com.zimug.bootlaunch.service.ArticleMybatisRestServiceImpl;
import com.zimug.bootlaunch.service.ArticleRestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@Controller
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource(name="articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;


    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "ArticleVO",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class)
    })
    //@RequestMapping(value = "/article", method = POST, produces = "application/json")
    @PostMapping("/article")
    public @ResponseBody  AjaxResponse saveArticle(@RequestBody ArticleVO article) {
    /*public @ResponseBody  AjaxResponse saveArticle(@RequestParam String  id,
                                                   @RequestParam String  author) {*/

        log.info("saveArticle：{}",article);

        log.info("articleRestService return :" + articleRestService.saveArticle(article));

        return  AjaxResponse.success(article);
    }
 
    //@RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/article/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable Long id) {

        articleRestService.deleteArticle(id);

        return AjaxResponse.success(id);
    }
 
    //@RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    @PutMapping("/article/{id}")
    public @ResponseBody AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO article) {
        article.setId(id);

        articleRestService.updateArticle(article);

        return AjaxResponse.success(article);
    }
 
    //@RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping( "/article/{id}")
    public @ResponseBody  AjaxResponse getArticle(@PathVariable Long id) {


        return AjaxResponse.success(articleRestService.getArticle(id));
    }


    //@RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping( "/article")
    public @ResponseBody  AjaxResponse getAll() {

        return AjaxResponse.success(articleRestService.getAll());
    }
}