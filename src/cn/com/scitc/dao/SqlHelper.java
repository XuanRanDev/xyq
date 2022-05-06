package cn.com.scitc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

// https://blog.csdn.net/educast/article/details/42501489
public class SqlHelper {
    // 定义要使用的变量
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static CallableStatement cs = null;

    private static String driver = "";
    private static String url = "";
    private static String user = "";
    private static String password = "";

    private static Properties pp = null;
    private static InputStream is = null;

    public static Connection getConn() {
        return conn;
    }

    public static PreparedStatement getPs() {
        return ps;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static CallableStatement getCs() {
        return cs;
    }

    // 加载驱动，只需要一次
    static {
        try {
            System.out.println("加载成功");
            pp = new Properties();
            is = SqlHelper.class.getClassLoader().getResourceAsStream("config.properties");
            pp.load(is);
            url = pp.getProperty("url");
            driver = pp.getProperty("driver");
            user = pp.getProperty("user");
            password = pp.getProperty("password");

            System.out.println(driver);
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            is = null;
        }
    }

    // 得到连接
    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 处理多个update/delete/insert
    public static void executeUpdateMultiParams(String[] sql,
                                                String[][] parameters) {
        try {
            // 获得连接
            conn = getConnection();
            // 可能传多条sql语句
            conn.setAutoCommit(false);
            for (int i = 0; i < sql.length; i++) {
                if (parameters[i] != null) {
                    ps = conn.prepareStatement(sql[i]);
                    for (int j = 0; j < parameters[i].length; j++)
                        ps.setString(j + 1, parameters[i][j]);
                }
                ps.executeUpdate();
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            // 关闭资源
            close(rs, ps, conn);
        }
    }


    public static void executeUpdate(String sql, Object[] parameters) {
        try {
            // 1.创建一个ps
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            // 给？赋值
            if (parameters != null)
                for (int i = 0; i < parameters.length; i++) {
                    //ps.setString(i + 1, parameters[i]);
                    ps.setObject(i + 1, parameters[i]);
                }
            // 执行
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();// 开发阶段
            throw new RuntimeException(e.getMessage());
        } finally {
            // 关闭资源
            close(rs, ps, conn);
        }
    }

    // select
    public static ResultSet executeQuery(String sql, String[] parameters) {
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    ps.setString(i + 1, parameters[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {

        }
        return rs;
    }

    // 调用无返回值存储过程
    // 格式： call procedureName(parameters list)
    public static void callProc(String sql, String[] parameters) {
        try {
            conn = getConnection();
            cs = conn.prepareCall(sql);
            // 给？赋值
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++)
                    cs.setObject(i + 1, parameters[i]);
            }
            cs.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            // 关闭资源
            close(rs, cs, conn);
        }
    }

    // 调用带有输入参数且有返回值的存储过程
    public static CallableStatement callProcInput(String sql, String[] inparameters) {
        try {
            conn = getConnection();
            cs = conn.prepareCall(sql);
            if(inparameters!=null)
                for(int i=0;i<inparameters.length;i++)
                    cs.setObject(i+1, inparameters[i]);
            cs.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally{

        }
        return cs;
    }

    // 调用有返回值的存储过程
    public static CallableStatement callProcOutput(String sql,Integer[] outparameters) {
        try {
            conn = getConnection();
            cs = conn.prepareCall(sql);
            //给out参数赋值
            if(outparameters!=null)
                for(int i=0;i<outparameters.length;i++)
                    cs.registerOutParameter(i+1, outparameters[i]);
            cs.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally{

        }
        return cs;
    }
    //释放链接
    public static void release(Statement ps, Connection conn){
        if(ps != null){
            try {
                ps.close();
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
    public static void close(ResultSet rs, Statement ps, Connection conn) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        rs = null;
        if (ps != null)
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        ps = null;
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        conn = null;
    }
    public static void closeAll(Connection conn,PreparedStatement pst,ResultSet rs)
    {
        try {
            if(rs!=null)
            {
                rs.close();
            }
            if(pst!=null)
            {
                pst.close();
            }
            if(conn!=null)
            {
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void closeBoth(Connection conn,PreparedStatement pst)
    {
        try {

            if(pst!=null)
            {
                pst.close();
            }
            if(conn!=null)
            {
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
