package cn.com.scitc.dao;

import cn.com.scitc.model.User;

import java.sql.*;

public class LoginDao {
/*
    //登录方法
    public String Login(String loginId, String password) {
        //
        boolean has_loginId = false;
        boolean password_cor = false;
        //关联数据库并且查出用户名和密码
        String sql = "select * from user";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;


        try {
            conn = JDBCUtil.getConn();
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //将数据库中的值拿出来并去除空格
            while (rs.next()) {
                String temp_loginId = rs.getString("loginId").trim();
                String temp_password = rs.getString("password").trim();
                //判断是否和数据库值是否相等
                if (loginId.equals(temp_loginId)) {
                    has_loginId = true;
                    if (password.equals(temp_password)) {
                        password_cor = true;
                        //密码和账号都正确
                        return "has_UserAndPwd";
                    }
                    //密码或账号有一个错误
                    return "has_UserOrPwd";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //用户不存在
        return "no";
    }
    */
/*
    public String Login(String loginId, String password) {
        //
        boolean has_loginId = false;
        boolean password_cor = false;
        //关联数据库并且查出用户名和密码
        String sql = "select * from user";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = SqlHelper.getConnection();
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //将数据库中的值拿出来并去除空格
            while (rs.next()) {
                String temp_loginId = rs.getString("loginId").trim();
                String temp_password = rs.getString("password").trim();
                //判断是否和数据库值是否相等
                if (loginId.equals(temp_loginId)) {
                    has_loginId = true;
                    if (password.equals(temp_password)) {
                        password_cor = true;
                        //密码和账号都正确
                        return "has_UserAndPwd";
                    }
                    //密码或账号有一个错误
                    return "has_UserOrPwd";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //用户不存在
        return "no";
    }
*/
        //另一种登录方法（简易）
       /* public boolean getSelect(String loginId, String password) {
        boolean flag=false;
        String sql = "select * from user where loginId='"+loginId+"' and password='"+password+"'";

        Connection conn = getCon();
        PreparedStatement pst = null;
        try {
            pst = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                flag=true;
            }
        } catch (Exception e) {
        }
        return flag;
         }*/
        public static User validatePassword(User user) {
            String sql = "SELECT * FROM user WHERE loginId=?";
            Connection conn;
            try {
                conn = SqlHelper.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, user.getLoginId());
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    String password = rs.getString("password");
                    if (password.equals(user.getPassword())){
                        user.setU_id(rs.getInt("u_id"));
                        user.setUserName(rs.getString("userName"));
                        user.setMobile(rs.getString("mobile"));
                        user.setU_flag(rs.getString("u_flag"));
                        user.setEmail(rs.getString("email"));
                        return user;
                    } else {
                        return null;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

}


