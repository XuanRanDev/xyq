package cn.com.scitc.orders;

import cn.com.scitc.dao.OrdersDao;
import cn.com.scitc.model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrdersServlet",urlPatterns = "/orders")
public class OrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrdersDao dao = new OrdersDao();
        List<Orders> list = dao.findAllorders();

        request.setAttribute("list",list);
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
}
