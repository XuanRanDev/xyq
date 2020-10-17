package cn.com.scitc.admin;

import cn.com.scitc.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleUserServlet",urlPatterns = "/filterAdmin/del")
public class DeleUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        UserDao dao = new UserDao();
        dao.delById(id);
        System.out.println("删除成功");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script language='javascript'>alert('用户删除成功');window.location.href='adminUser';</script>");
    }
}
