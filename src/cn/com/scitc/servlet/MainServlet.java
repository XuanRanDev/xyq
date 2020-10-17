package cn.com.scitc.servlet;

import cn.com.scitc.dao.FoodDao;
import cn.com.scitc.model.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainServlet",urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FoodDao dao = new FoodDao();
        List<Food> list = dao.findAll();

        request.setAttribute("list",list);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
