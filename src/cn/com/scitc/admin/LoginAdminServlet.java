package cn.com.scitc.admin;

import cn.com.scitc.dao.LoginDao;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginAdminServlet",urlPatterns = "/loginAdmin")
public class LoginAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        User user = new User();
        String loginId = user.setLoginId(request.getParameter("loginId"));
        String passwod = user.setPassword(request.getParameter("password"));
        //判断是否登录成功
        User curUser = LoginDao.validatePassword(user);
        if (curUser != null && curUser.getU_flag().equals("管理员")){
            Cookie cookie = new Cookie("user",loginId);
            Cookie cookie1 = new Cookie("pwd",passwod);
            HttpSession session = request.getSession(true);
            session.setAttribute("user", curUser);
            session.setAttribute("loginId",loginId);
            response.addCookie(cookie);
            response.addCookie(cookie1);
            response.sendRedirect("http://localhost:8080/Demo/admin.jsp");
        } else if (curUser != null){
            response.getWriter().println("<script LANGUAGE='javascript'> alert('权限不够！！！');self.location='adminLogin'</script>");
        }else {
            response.getWriter().println("<script LANGUAGE='javascript'> alert('用户名或密码错误！');self.location='adminLogin'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
