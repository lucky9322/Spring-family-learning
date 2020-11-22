package com.lucky.spring.service.impl;


import com.lucky.spring.service.MailService;
import com.lucky.spring.util.CreateMailContentUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * Created by zhangdd on 2020/11/21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendSimpleMail() {
        mailService.sendSimpleMail("lucky9322@163.com","hello","你好 mail");
    }

    @Test
    public void testSendHtmlMail() {
        mailService.sendHtmlMail("lucky9322@163.com","hello", CreateMailContentUtil.createForgetMailContent(null,null,0));
    }

    @Test
    public void sendAttachmentsMail() {
        File file=new File(System.getProperty("user.dir")+"/HELP.md");
        mailService.sendAttachmentsMail("lucky9322@163.com","hello file","查看附件 哦",file.getAbsolutePath());
    }
}