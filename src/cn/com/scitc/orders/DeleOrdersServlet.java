package cn.com.scitc.orders;

import cn.com.scitc.dao.OrdersDao;
import cn.com.scitc.model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleOrdersServlet",urlPatterns = "/delOrders")
public class DeleOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        OrdersDao dao = new OrdersDao();
        dao.delByOid(id);
        System.out.println("删除成功");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script language='javascript'>alert('删除成功');window.location.href='orders';</script>");
    }
}
