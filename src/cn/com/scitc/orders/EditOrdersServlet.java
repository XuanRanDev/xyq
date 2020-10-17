package cn.com.scitc.orders;

import cn.com.scitc.dao.OrdersDao;
import cn.com.scitc.model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditOrdersServlet",urlPatterns = "/editOrders")
public class EditOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Orders orders = new OrdersDao().searchById(id);
        orders.setPzstate("正在配送");
        new OrdersDao().adminUpdate(orders);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script language='javascript'>alert('订单已受理，正在配送中');window.location.href='orders';</script>");

    }
}
