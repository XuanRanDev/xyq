package cn.com.scitc.admin;

import cn.com.scitc.dao.CommentDao;
import cn.com.scitc.model.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCommentServlet",urlPatterns = "/adminComment")
public class AdminCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommentDao dao = new CommentDao();
        List<Comment> list = dao.findAllCom();

        request.setAttribute("list",list);
        request.getRequestDispatcher("adminComment2.jsp").forward(request ,response);
    }
}
