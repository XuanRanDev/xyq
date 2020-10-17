package cn.com.scitc.servlet;

import cn.com.scitc.dao.OrdersDao;
import cn.com.scitc.model.Orders;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderPayServlet",urlPatterns = "/orderPay")
public class OrderPayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Orders> list;
        User user = (User) request.getSession().getAttribute("user");
        OrdersDao dao = new OrdersDao();
        list = dao.searchBuy(user);
            for (Orders orders : list) {
                orders.setState("货到付款");
                orders.setPzstate("等待配送");
                orders.setPd("是");
                dao.update(orders);
            }
            System.out.println("订单已提交！");
            response.getWriter().println("<script LANGUAGE='javascript'> alert('订单已生成，请等待配送！');window.location.href='shopping';</script>");


    }
}
