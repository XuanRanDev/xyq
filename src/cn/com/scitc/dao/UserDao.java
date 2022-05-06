package cn.com.scitc.dao;

import cn.com.scitc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao{
    /*
    * 查出所有权限为普通用户的用户信息
    * */
    public List<User> serchByFlag(){
        String sql = "select * from user where u_flag='普通用户'";
        ResultSet resultSet = SqlHelper.executeQuery(sql, null);
        List<User> listFlag = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setU_id(resultSet.getInt("u_id"));
                user.setLoginId(resultSet.getString("loginId"));
                user.setPassword(resultSet.getString("password"));
                user.setUserName(resultSet.getString("userName"));
                user.setMobile(resultSet.getString("mobile"));
                user.setU_flag(resultSet.getString("u_flag"));
                user.setEmail(resultSet.getString("email"));
                listFlag.add(user);
            }
        } catch (Exception er) {
            er.printStackTrace();
        }
        return listFlag;
    }
    /*
    * 关于用户信息的模糊查询
    * */
    public List<User> seleUser(String key){
        String sql = "select * from user where loginId like ? or u_flag like  ?";
        String[] ps = new String[2];
        ps[0] = "%" + key + "%";
        ps[1] = "%" + key + "%";
        ResultSet resultSet = SqlHelper.executeQuery(sql, ps);
        List<User> seleList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setU_id(resultSet.getInt("u_id"));
                user.setLoginId(resultSet.getString("loginId"));
                user.setPassword(resultSet.getString("password"));
                user.setUserName(resultSet.getString("userName"));
                user.setMobile(resultSet.getString("mobile"));
                user.setU_flag(resultSet.getString("u_flag"));
                user.setEmail(resultSet.getString("email"));
                seleList.add(user);
            }

        } catch (Exception er) {
            er.printStackTrace();
        }
        return seleList;
    }
    /*
    * 删除用户
    * */
    public boolean delById(Integer id) {
        String sql = "delete from user where u_id = ?";
        SqlHelper.executeUpdate(sql, new Object[]{id});
        return true;
    }
    /*
    * 查询用户所有信息
    * */
    public List<User> findAll(){
        String sql = "select * from user";
        ResultSet resultSet = SqlHelper.executeQuery(sql, null);
        List<User> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setU_id(resultSet.getInt("u_id"));
                user.setLoginId(resultSet.getString("loginId"));
                user.setPassword(resultSet.getString("password"));
                user.setUserName(resultSet.getString("userName"));
                user.setMobile(resultSet.getString("mobile"));
                user.setU_flag(resultSet.getString("u_flag"));
                user.setEmail(resultSet.getString("email"));
                list.add(user);
            }
        } catch (Exception er) {
            er.printStackTrace();
        }
        return list;
    }
    //根据账号查出所有信息
    public  User searchByUsername(String loginId) {
        String sql = "select * from user where loginId = ?";
        String[] ps = new String[1];
        ps[0] = loginId;

        ResultSet resultSet = SqlHelper.executeQuery(sql, ps);
        try{
            while (resultSet.next()) {
                User user = new User();
                user.setU_id(resultSet.getInt("u_id"));
                user.setLoginId(resultSet.getString("loginId"));
                user.setPassword(resultSet.getString("password"));
                user.setUserName(resultSet.getString("userName"));
                user.setMobile(resultSet.getString("mobile"));
                user.setU_flag(resultSet.getString("u_flag"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        }catch (Exception er){
            er.printStackTrace();
        }
        return null;

    }
/*
    public static boolean searchByUsername(User user) {
        String sql = "SELECT * FROM user WHERE loginId=?";
        try {
            Connection conn = SqlHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getLoginId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }*/

    public static int updatePermission(String id, String permission) {
        String sql = "UPDATE user SET u_flag = ? WHERE loginId=?";
        int i = 0;
        try {
            Connection conn = SqlHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, permission);
            ps.setString(2, String.valueOf(id));
            i = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }



    //修改用户信息
    public static int update(User user) {
        String sql = "UPDATE user SET loginId=?, password=?, userName=?, mobile=?, u_flag=?, email=? WHERE u_id=?";
        int i = 0;
        try {
            Connection conn = SqlHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getLoginId());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getMobile());
            ps.setString(5, user.getU_flag());
            ps.setString(6, user.getEmail());
            ps.setInt(7, user.getU_id());
            i = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    //根据Id查询用户
    public static User searchById(int id) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE u_id=?";
        try {
            Connection conn = SqlHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                user.setU_id(rs.getInt("u_id"));
                user.setLoginId(rs.getString("loginId"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("userName"));
                user.setMobile(rs.getString("mobile"));
                user.setU_flag(rs.getString("u_flag"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    /*
    public static User getEmail(String email){
        //先查找前端页面传过来的邮箱是否存在，若存在则把账号、密码、邮箱返回给servlet
        User user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = SqlHelper.getConnection();
            String sql="select loginId,password,email  from user where email=?";
            pst =  conn.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
                String loginId=rs.getString(1);
                String password=rs.getString(2);
                email = rs.getString(3);
                user = new User(loginId,password,email);
                return user;

            }
            else{
                return user;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
/*
    public User Email_pwd () {
        //先查找前端页面传过来的邮箱是否存在，若存在则把账号、密码、邮箱返回给servlet
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        User user = null;
        try {
            conn = SqlHelper.getConnection();
            String sql = "select *  from user";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                user.setLoginId(rs.getString("loginId"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;

        /*
        boolean has_email = false;
        //关联数据库并且查出用户名和密码和邮箱
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
                String temp_email = rs.getString("email").trim();
                String temp_loginId = rs.getString("loginId").trim();
                String temp_password = rs.getString("password").trim();
                //判断是否和数据库值是否相等
                if (email.equals(temp_email)) {
                    has_email = true;
                    //邮箱正确
                    return "has_Email";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //邮箱不存在
        return "Email_no";

    }
    */

    //检测用户是否已使用
    public boolean check(String loginId) {
        // TODO Auto-generated method stub
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = SqlHelper.getConnection();
            String sql = "select * from user where loginId =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, loginId);
            rs = pst.executeQuery();

            while(rs.next()){
                flag = true;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            SqlHelper.close(rs, pst, conn);
        }
        return flag;
    }
    //检测邮箱是否已使用
    public boolean check1(String email) {
        // TODO Auto-generated method stub
        boolean flag1 = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = SqlHelper.getConnection();
            String sql = "select * from user where email =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();

            while(rs.next()){
                flag1 = true;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            SqlHelper.close(rs, pst, conn);
        }

        return flag1;
    }
    /*另一种注册方法
    public void add(String loginId,String password,String userName,String mobile,String address,String email){
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = SqlHelper.getConnection();
            String sql = "insert into user(loginId, password, userName, mobile, address, email) values("+loginId+","+password+","+userName+","+mobile+","+address+","+email+");";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SqlHelper.release(pst, conn);
        }
    }
    */
    //注册
    public boolean add(User user){
        String sql = "insert into user(loginId,password,userName,mobile,u_flag,email) values(?,?,?,?,?,?)";
        Object[] ps = new Object[6];
        ps[0] = user.getLoginId();
        ps[1] = user.getPassword();
        ps[2] = user.getUserName();
        ps[3] = user.getMobile();
        ps[4] = user.getU_flag();
        ps[5] = user.getEmail();
        SqlHelper.executeUpdate(sql ,ps);
        return true;
    }
}
