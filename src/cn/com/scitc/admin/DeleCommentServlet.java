package cn.com.scitc.admin;

import cn.com.scitc.dao.CommentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleCommentServlet",urlPatterns = "/filterAdmin/deleComment")
public class DeleCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        CommentDao dao = new CommentDao();
        boolean b = dao.delByCid(id);
        System.out.println("删除状态：" + b);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script language='javascript'>alert('评论删除成功');history.back(-1);</script>");
    }
}
