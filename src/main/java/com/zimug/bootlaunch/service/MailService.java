package com.zimug.bootlaunch.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {
    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    /**
     * 发送文本邮件
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }


    /**
     * 发送html邮件
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        //注意这里使用的是MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        //第二个参数是否是html，true
        helper.setText(content, true);

        mailSender.send(message);
    }



    /**
     * 发送带附件的html邮件
     */
    public void sendAttchmentHtmlMail(String to, String subject, String content,String filePath) throws MessagingException {
        //注意这里使用的是MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        //第二个参数是否是html，true
        helper.setText(content, true);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName, file);

        mailSender.send(message);
    }



    /**
     * 发送带内联附件的html邮件
     */
    public void sendResourceAttchmentHtmlMail(String to, String subject, String content,String filePath) throws MessagingException {
        //注意这里使用的是MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        //第二个参数是否是html，true
        helper.setText(content, true);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        helper.addInline("gaoyuanyuan", file);

        mailSender.send(message);
    }

}