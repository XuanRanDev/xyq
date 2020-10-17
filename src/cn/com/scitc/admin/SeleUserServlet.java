package cn.com.scitc.admin;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SeleUserServlet",urlPatterns = "/filterAdmin/seleUser")
public class SeleUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        UserDao dao = new UserDao();
        List<User> seleList = dao.seleUser(key);

        request.setAttribute("seleList",seleList);
        System.out.println("搜索信息为：" + key);
        request.getRequestDispatcher("seleUser.jsp").forward(request, response);
    }
}
