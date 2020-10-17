package cn.com.scitc.servlet;

import cn.com.scitc.dao.CommentDao;
import cn.com.scitc.model.Comment;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CommentAddServlet",urlPatterns = "/commentAdd")
public class CommentAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_xinxi = request.getParameter("c_xinxi");
        User person = (User) request.getSession().getAttribute("user");
        Comment comment = new Comment();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        comment.setC_xinxi(c_xinxi);
        comment.setLoginId(person.getLoginId());
        long time = 0;
        try {
            time = dateFormat.parse(dateFormat.format(date)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(time);
        comment.setTime(new Date(time));
        new CommentDao().addComment(comment);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script language='javascript'>alert('评论成功');window.location.href='comment';</script>");

    }
}
