package cn.com.scitc.servlet;

import cn.com.scitc.dao.SendMail;
import cn.com.scitc.dao.UserDao;
import cn.com.scitc.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "Email_DServlet",urlPatterns = "/em")
public class Email_DServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取用户的邮箱
        String email = request.getParameter("email");
        User user = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //实例化一个发送邮件的对象
        SendMail mySendMail = new SendMail();
        //根据邮箱找到该用户信息
        //UserDao pwd = new UserDao();
       // User user = pwd.Email_pwd();
        //boolean flag1 = UserDao.check1(email);
        //user = UserDao.getEmail(email);
        if(user != null) {
            //设置收件人和消息内容
            mySendMail.sendMail(email, "图书管理系统提醒，您的密码为："+ /*user.getPassword()*/ "123");
            out.println("<script>alert('恭喜，找回密码成功');window.location.href='login.jsp'</script>");
        }else{
            mySendMail.sendMail(email, "图书管理系统提醒，您的密码为："+ /*user.getPassword()*/ "123");
            out.println("<script>alert('恭喜，找回密码成功');window.location.href='login.jsp'</script>");
            //out.println("<script>alert('该邮箱尚未注册！请重新输入');window.location.href='email.jsp'</script>");
        }

/*
        //接收页面传过来的QQ邮箱号
        String email  = request.getParameter("email");
        //传到数据库，判断是否存在，如果存在，返回用户账号信息
        SendMail send = new SendMail();
        User user = send.getEmail(email);
        //System.out.println(user.getEmail());
        //to接收的是用户注册时的邮箱号，也就是就是收件人的，将接收到后台发送的密码
        String to = user.getEmail();
        // 发件人电子邮箱，你可以改成自己的邮箱号
        String from = "1292213372@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
         // 设置邮件服务器
        // 获取系统属性
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("1292213372@qq.com", "trvqvvnummsxicjd");
                //发件人邮件用户名、授权码（授权码要与QQ邮箱相对应，可以从邮箱设置里面获得，详细步骤在博客开头）
            }
        });
        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("您的员工管理系统，密码是："+user.getPassword());

            // 发送消息
            Transport.send(message);
            //System.out.println("Sent message successfully....from runoob.com");
            //传到页面
            request.setAttribute("MSG3", "发送成功，请注意查收！");

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
*/
    }

}




