package cn.com.scitc.servlet;

import cn.com.scitc.dao.LoginDao;
import cn.com.scitc.model.User;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Login_DServlet",urlPatterns = "/usr")
public class Login_DServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        User user = new User();
        user.setLoginId(request.getParameter("loginId"));
        user.setPassword(request.getParameter("password"));
        //判断是否登录成功
        User curUser = LoginDao.validatePassword(user);
        if (curUser != null){
            HttpSession session = request.getSession(true);
            //将数据传入session中
            session.setAttribute("user", curUser);
            //登录成功跳转主界面
            response.sendRedirect("./main");
        } else {
            response.getWriter().println("<script LANGUAGE='javascript'> alert('用户名或密码错误！');self.location='login'</script>");
        }
        /*
        //利用getParameter方法获取到前台文本框中输入的值，其中括号内的内容为<input/>标签中的name属性
        String loginId=request.getParameter("loginId").trim();
        String password=request.getParameter("password").trim();
        //调用方法
        LoginDao ld = new LoginDao();
        String result = ld.Login(loginId, password);
        //从页面获取的值与数据库中的值进行比较
        if (result.equals("has_UserAndPwd")){      //这里equals指向String类的equals，只是单纯比较两个字符串是否一样

            request.getSession().setAttribute("loginId", loginId);

            response.sendRedirect("./main");
            //request.getRequestDispatcher("register.jsp").forward(request, response);
        }else if (result.equals("has_UserOrPwd")){
            response.getWriter().write("<script language='javascript'>alert('账户或密码错误');window.location.href='login';</script>");
        }else if (result.equals("no")){
            response.getWriter().write("<script language='javascript'>alert('该用户不存在，请先注册');window.location.href='login';</script>");
        }
        */
        //记住我

       //另一种实现登录方法
       /*String loginId=request.getParameter("loginId");
        String password=request.getParameter("password");
        //调用UserDao中的getSelect方法并获取到返回值
        boolean flag= LoginDao.getSelect(loginId, password);
        //若用户名和密码存在则转发到index.jsp页面，否则重定向到error.jsp页面
        if (flag) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<script language='javascript'>alert('用户名或密码错误');window.location.href='login';</script>");
        }
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
