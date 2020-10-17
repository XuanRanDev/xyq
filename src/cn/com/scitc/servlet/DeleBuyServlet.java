package cn.com.scitc.servlet;

import cn.com.scitc.dao.OrdersDao;
import cn.com.scitc.model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleBuyServlet",urlPatterns = "/deleBuy")
public class DeleBuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        OrdersDao dao = new OrdersDao();
        String id = request.getParameter("id");
        Orders order = new Orders();
        order.setO_id(Integer.parseInt(id));
        dao.delete(order);
        response.getWriter().println("<script LANGUAGE='javascript'> alert('删除成功！');self.location='shopping';</script>");

    }
}
