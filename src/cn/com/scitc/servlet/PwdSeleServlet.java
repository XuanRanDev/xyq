package cn.com.scitc.servlet;

import cn.com.scitc.dao.UserDao;
import cn.com.scitc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PwdSeleServlet",urlPatterns = "/pwdSele")
public class PwdSeleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdSeleServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        User user = new User();
        String loginId = request.getParameter("loginId");
        System.out.println(loginId);
        User sti = new UserDao().searchByUsername(loginId);
        String isEmail = sti.getEmail();
        String email = request.getParameter("email");
        System.out.println(isEmail);
        System.out.println(email);
        String psw = request.getParameter("password1");
            if (email.equals(isEmail)){		//邮箱正确
                sti.setPassword(psw);
                UserDao.update(sti);
                response.getWriter().println("<script LANGUAGE='javascript'> alert('密码修改成功！');self.location='login'</script>");
            } else {									//邮箱错误
                response.getWriter().println("<script LANGUAGE='javascript'> alert('邮箱输入错误！');history.go(-1);</script>");
            }
        }

    }

