package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.config.exception.ModelView;
import com.zimug.bootlaunch.model.ArticleVO;
import com.zimug.bootlaunch.service.ArticleRestService;
import com.zimug.bootlaunch.service.ExceptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource(name="articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;

    @Resource
    ExceptionService exceptionService;

    @ModelView
    @GetMapping("/freemarker")
    public String index(Model model) {

        List<ArticleVO> articles = articleRestService.getAll();

        model.addAttribute("articles", articles);
        exceptionService.systemBizError();

        //模版名称，实际的目录为：resources/templates/fremarkertemp.html
        return "fremarkertemp";
    }
}