package cn.com.scitc.dao;

import java.sql.*;

public class JDBCUtil {/*
    static String username = "order";
    static String password = "123";
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/ordering?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    //获取链接
    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username, password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
    //释放链接
    public static void release(Statement stmt, Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //重载释放链接
    public static void release(ResultSet rs , Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    */
}
