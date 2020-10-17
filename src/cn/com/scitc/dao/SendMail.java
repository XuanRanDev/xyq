package cn.com.scitc.dao;

import cn.com.scitc.model.User;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

public class SendMail {
/*
    public User getEmail(String email){
        //先查找前端页面传过来的邮箱是否存在，若存在则把账号、密码、邮箱返回给servlet
        User user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = SqlHelper.getConnection();
            String sql="select loginId,password,email  from user where email=?";
            pst =  conn.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
                String loginId=rs.getString(1);
                String password=rs.getString(2);
                email = rs.getString(3);
                user = new User(loginId,password,email);
                return user;

            }
            else{
                return user;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
    */


    // 发件人的邮箱账号如：xxx@163.com
    public static String sendEmailAccount = "1292213372@qq.com";
    // 发件人的邮箱的授权码(自己在邮箱服务器中开启并设置)
    public static String sendEmailPassword = "trvqvvnummsxicjd";
    // 发件人邮箱的SMTP服务器地址，如：smtp.qq.com
    public static String sendEmailSMTPHost = "smtp.qq.com";
    // 收件人的邮箱账号
    public static String receiveMailAccount = "";

    // 把发送邮件封装为函数，参数为收件人的邮箱账号和要发送的内容
    public void sendMail(String receiveMailAccount, String mailContent) {
        // 创建用于连接邮件服务器的参数配置
        Properties props = new Properties();
        // 设置使用SMTP协议
        props.setProperty("mail.transport.protocol", "smtp");
        // 设置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host", sendEmailSMTPHost);
        // 设置需要验证
        props.setProperty("mail.smtp.auth", "true");

        // 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置debug模式，便于查看发送过程所产生的日志
        session.setDebug(true);

        try {
            // 创建一封邮件
            MimeMessage message = createMimeMessage(session, sendEmailAccount, receiveMailAccount, mailContent);

            // 根据 Session 获取邮件传输对象
            Transport transport = session.getTransport();

            transport.connect(sendEmailAccount, sendEmailPassword);

            // 发送邮件, 发到所有的收件地址, 通过message.getAllRecipients() 可以获取到在创建邮件对象时添加的所有收件人
            transport.sendMessage(message, message.getAllRecipients());

            // 关闭连接
            transport.close();
        } catch (NoSuchProviderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     *
     * @param session
     *            和服务器交互的会话
     * @param sendMail
     *            发件人邮箱
     * @param receiveMail
     *            收件人邮箱
     * @return
     * @throws Exception
     */

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,
                                                String mailContent) throws Exception {
        // 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 设置发件人姓名和编码格式
        message.setFrom(new InternetAddress(sendMail, "订餐系统", "UTF-8"));

        // 收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "尊敬的用户", "UTF-8"));

        // 设置邮件主题
        message.setSubject("找回密码提醒", "UTF-8");

        // 设置邮件正文
        message.setContent(mailContent, "text/html;charset=UTF-8");

        // 设置发件时间
        message.setSentDate(new Date());

        // 保存设置
        message.saveChanges();

        return message;
    }

}
