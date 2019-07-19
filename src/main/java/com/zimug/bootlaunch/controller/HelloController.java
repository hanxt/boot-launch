package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    //private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public ArticleVO hello() {
        /*ArticleRestService article = new ArticleRestService(1L,"zimug");

        article.setAuthor("字母哥");*/

        ArticleVO article1 = ArticleVO.builder().id(3L).author("莫言").build();

        log.info("测试一下" + article1);

        return article1;
    }

}
