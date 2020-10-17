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

@WebServlet(name = "SeleF_nameServlet",urlPatterns = "/seleF_name")
public class SeleF_nameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        FoodDao dao = new FoodDao();
        List<Food> f_list = dao.findMeu(key);
        request.setAttribute("f_list", f_list);
        request.getRequestDispatcher("seleF_name.jsp").forward(request, response);
    }
}
