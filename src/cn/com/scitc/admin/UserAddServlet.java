package cn.com.scitc.admin;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserAddServlet",urlPatterns = "/filterAdmin/userAdd")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try{
            //loginId用户来判断
            String loginId =  user.setLoginId(request.getParameter("loginId"));
            //调取网页输入的值并进行修改
            user.setPassword(request.getParameter("password"));
            user.setUserName(request.getParameter("userName"));
            user.setMobile(request.getParameter("mobile"));
            user.setU_flag(request.getParameter("u_flag"));
            String email = user.setEmail(request.getParameter("email"));
            //判断loginId是否存在
            boolean flag = new UserDao().check(loginId);
            boolean flag1 = new UserDao().check1(email);
            if(flag){
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<script language='javascript'>alert('该账号已存在');history.go(-1);</script>");
            }else if (flag1){
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<script language='javascript'>alert('该邮箱已存在');history.go(-1);</script>");
            } else{
                //调用注册方法
                new UserDao().add(user);
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<script language='javascript'>alert('添加成功');history.go(-1);</script>");
            }
        }catch (Exception er){
            er.printStackTrace();
        }
        System.out.println("添加成功");
    }
}
