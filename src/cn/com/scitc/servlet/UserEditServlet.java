package cn.com.scitc.servlet;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserEditServlet",urlPatterns = "/userEdit")
public class UserEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserEditServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String  mobile = request.getParameter("mobile");
        User person = (User) request.getSession().getAttribute("user");
        person.setUserName(userName);
        person.setMobile(mobile);
        UserDao.update(person);
        System.out.println("id: " + person.getU_id());
        System.out.println("loginId: " + person.getLoginId());
        System.out.println("email" + person.getEmail());
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<script LANGUAGE='javascript'> alert('修改成功！');history.go(-1);</script>");

        /*最开始用来判断用户是否登录，登录就可以修改个人信息等，没登录就跳转登录页面
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            response.sendRedirect("./login");
            return;
        }
        if (user.getU_id() < 0 ){
            response.sendRedirect("./login");
            return;
        }
        if ("管理员".equals(user.getU_flag())){
            response.sendRedirect("./register");
        } else {
            response.sendRedirect("./editPassword");
        }
        */
    }
}
