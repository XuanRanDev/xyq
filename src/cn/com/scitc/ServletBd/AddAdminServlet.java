package cn.com.scitc.ServletBd;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddAdminServlet",urlPatterns = "/addAdmin")
public class AddAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        List<User> listFlag = dao.serchByFlag();
        System.out.println(listFlag);
        request.setAttribute("listFlag",listFlag);
        request.getRequestDispatcher("addAdmin.jsp").forward(request, response);
    }
}
