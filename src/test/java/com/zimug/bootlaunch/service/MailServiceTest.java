package com.zimug.bootlaunch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
}