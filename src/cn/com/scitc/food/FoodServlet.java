package cn.com.scitc.food;

import cn.com.scitc.dao.FoodDao;
import cn.com.scitc.model.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FoodServlet",urlPatterns = "/food")
public class FoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FoodDao dao = new FoodDao();
        List<Food>  foodList = dao.findAll();

        request.setAttribute("foodList",foodList);
        request.getRequestDispatcher("food.jsp").forward(request, response);
    }
}
