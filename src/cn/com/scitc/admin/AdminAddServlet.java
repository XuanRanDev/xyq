package cn.com.scitc.admin;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminAddServlet",urlPatterns = "/filterAdmin/adminAdd")
public class AdminAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserDao dao = new UserDao();
        String loginId = request.getParameter("loginId");
        User user = dao.searchByUsername(loginId);
        user.setU_flag("管理员");
        dao.update(user);
        response.getWriter().println("<script LANGUAGE='javascript'> alert('添加管理员成功！');history.go(-1);</script>");
    }
}
