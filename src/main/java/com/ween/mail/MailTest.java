package com.ween.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by wen on 2018/4/8
 */
public class MailTest {
     /**
     * 使用Transport 非静态方法 发送邮件
     */
    public static void main(String[] args)  throws Exception{
        transportStatic();
    }

    public static void transport() throws Exception{
        // 属性
        Properties properties = new Properties();
        // 设置认证属性
        properties.setProperty("mail.smtp.auth", "true");
        // 设置通信协议
        properties.setProperty("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(properties);
        session.setDebug(true);

        //邮件开始
        Message message = new MimeMessage(session);
        message.setSubject("邮件主题");
        message.setFrom(new InternetAddress("wuwenhao1994@yeah.net"));
        message.setText("邮件内容");

        Transport transport = session.getTransport();
        transport.connect("smtp.yeah.net", 25, "wuwenhao1994@yeah.net", "zz666321.0");
        transport.sendMessage(message, new Address[]{new InternetAddress("12345@qq.com")});
        transport.close();
    }

    public static void transportStatic() throws Exception{
        Properties properties=new Properties();
        properties.setProperty("mail.debug","true");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.stmp.port","25");
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.host","smtp.yeah.net");

        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("wuwenhao1994@yeah.net","zz666321.0");
            }
        });

        Message message=new MimeMessage(session);
        message.setSubject("中文主题");
        message.setFrom(new InternetAddress("wuwenhao1994@yeah.net"));
        //多收件人
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("1093526612@qq.com,1093526613@qq.com"));
        // 抄送人
        message.setRecipient(Message.RecipientType.CC, new InternetAddress("aaaaaa@163.com"));
        // 暗送人
        message.setRecipient(Message.RecipientType.BCC, new InternetAddress("bbbbbbb@163.com"));
        // HTML内容
        message.setContent("<span style='color:red'>中文呵呵</span>","text/html;charset=utf-8");
        Transport.send(message);
    }
}
