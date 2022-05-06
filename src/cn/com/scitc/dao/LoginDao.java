package cn.com.scitc.dao;

import cn.com.scitc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public static User validatePassword(User user) {
        String sql = "SELECT * FROM user WHERE loginId=?";
        Connection conn;
        try {
            conn = SqlHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getLoginId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                if (password.equals(user.getPassword())) {
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


