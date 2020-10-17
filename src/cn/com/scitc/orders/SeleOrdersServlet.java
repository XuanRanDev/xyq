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

@WebServlet(name = "SeleOrdersServlet",urlPatterns = "/seleOrders")
public class SeleOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        OrdersDao dao = new OrdersDao();
        List<Orders> o_list = dao.findOreders(key);
        request.setAttribute("o_list", o_list);
        request.getRequestDispatcher("seleOrders.jsp").forward(request, response);
    }
}
