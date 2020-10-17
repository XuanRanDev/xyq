package cn.com.scitc.admin;

import cn.com.scitc.dao.FoodDao;
import cn.com.scitc.model.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditFoodServlet",urlPatterns = "/filterAdmin/editFood")
public class EditFoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Food food = new FoodDao().searchById(id);

            request.setAttribute("food",food);
        }catch (Exception er){
            er.printStackTrace();
        }

        request.getRequestDispatcher("editFood.jsp").forward(request, response);
    }
}
