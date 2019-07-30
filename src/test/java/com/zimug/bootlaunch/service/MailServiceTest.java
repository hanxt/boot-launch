package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.model.ArticleVO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Resource
    MailService mailService;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("431899405@qq.com","普通文本邮件","普通文本邮件内容测试");
    }


    @Test
    public void sendHtmlMail() throws MessagingException {
        mailService.sendHtmlMail("431899405@qq.com","一封html测试邮件","<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                + " <div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                +"      <h3>\"一封html测试邮件\"</h3>\n"
                +"      <span>http://www.zimug.com</span>"
                + "     <div style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://zimug.com\" target=\"_bank\" >"
                + "           <strong>我很用心，希望你有所收获</strong></a></div>\n"
                + " </div>\n" + "</body>");
    }


    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Test
    public void sendTemplateMail() throws IOException, TemplateException, MessagingException {
        List<ArticleVO> articles = new ArrayList<>();
        articles.add(new ArticleVO(1L,"zimug","手摸手教你学spring boot","内容一",new Date(),null));
        articles.add(new ArticleVO(2L,"zimug","手摸手教你学spring boot","内容二",new Date(),null));

        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("fremarkertemp.html");

        Map<String,Object> model = new HashMap<>();
        model.put("articles",articles);
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);


        mailService.sendHtmlMail("431899405@qq.com","一封freemarker模板的html测试邮件",templateHtml);
    }

    @Test
    public void sendAttchmentHtmlMail() throws IOException, TemplateException, MessagingException {

        List<ArticleVO> articles = new ArrayList<>();
        articles.add(new ArticleVO(1L,"zimug","手摸手教你学spring boot","内容一",new Date(),null));
        articles.add(new ArticleVO(2L,"zimug","手摸手教你学spring boot","内容二",new Date(),null));

        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("fremarkertemp.html");

        Map<String,Object> model = new HashMap<>();
        model.put("articles",articles);
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);

        String filePath = "D:\\courseview\\springboot\\template.png";

        mailService.sendAttchmentHtmlMail("431899405@qq.com","一封freemarker模板的html测试邮件",templateHtml,filePath);
    }

    @Test
    public void sendResourceAttchmentHtmlMail() throws IOException, TemplateException, MessagingException {

        List<ArticleVO> articles = new ArrayList<>();
        articles.add(new ArticleVO(1L,"zimug","手摸手教你学spring boot","内容一",new Date(),null));
        articles.add(new ArticleVO(2L,"zimug","手摸手教你学spring boot","内容二",new Date(),null));

        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("fremarkertemp.html");

        Map<String,Object> model = new HashMap<>();
        model.put("articles",articles);
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);

        String filePath = "D:\\courseview\\springboot\\template.png";

        mailService.sendResourceAttchmentHtmlMail("431899405@qq.com","一封freemarker模板的html测试邮件",templateHtml,filePath);

    }
}