package cn.com.scitc.servlet;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PwdEditServlet",urlPatterns = "/pwdEdit")
public class PwdEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //String info = request.getParameter("info");
        //if (info.equals("updatepsw")) {//修改密码
            User person = (User) request.getSession().getAttribute("user");
            String oldPsw = UserDao.searchById(person.getU_id()).getPassword();
            System.out.println(oldPsw);
            String psw = request.getParameter("psw");
            String newPsw = request.getParameter("psw1");
            if (oldPsw.equals(psw)){	//原密码正确
                person.setPassword(newPsw);
                UserDao.update(person);
                response.getWriter().println("<script LANGUAGE='javascript'> alert('密码修改成功，请重新登录');history.go(-1);</script>");
            } else {					//原密码错误
                response.getWriter().println("<script LANGUAGE='javascript'> alert('原密码输入错误！');history.go(-1);</script>");
            }

        }
   // }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
