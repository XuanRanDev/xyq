package cn.com.scitc.admin;

import cn.com.scitc.dao.FoodDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleFoodServlet",urlPatterns = "/filterAdmin/delFood")
public class DeleFoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        FoodDao dao = new FoodDao();
        dao.delByFid(id);
        System.out.println("删除成功");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script language='javascript'>alert('删除成功');history.back(-1);</script>");
    }
}
