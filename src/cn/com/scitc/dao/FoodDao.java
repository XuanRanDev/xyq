package cn.com.scitc.dao;

import cn.com.scitc.model.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDao {
    /*
    *添加菜品信息
    * */
    public boolean inFood(Food food){
        String sql = "insert into food(f_image,f_name,price,f_content) values(?,?,?,?)";
        Object[] ps = new Object[4];
        ps[0] = food.getF_image();
        ps[1] = food.getF_name();
        ps[2] = food.getPrice();
        ps[3] = food.getF_content();
        SqlHelper.executeUpdate(sql, ps);
        return true;
    }
    /*
    * 修改菜品信息
    * */
    public boolean saveFood(Food food){
        String sql = "update food set f_image=?,f_name=?,price=?,f_content=? where f_id=?";
        Object[] ps = new Object[5];
        ps[0] = food.getF_image();
        ps[1] = food.getF_name();
        ps[2] = food.getPrice();
        ps[3] = food.getF_content();
        ps[4] = food.getF_id();
        SqlHelper.executeUpdate(sql, ps);
        return true;
    }
    /*
    * 删除菜品
    * */
    public boolean delByFid(Integer id) {
        String sql = "delete from food where f_id = ?";
        SqlHelper.executeUpdate(sql, new Object[]{id});
        return true;
    }
    /**
     * 根据ID查询菜品
     */
    public Food searchById(int id) {
        String sql = "SELECT * FROM food WHERE f_id=?";
        try {
            Connection conn = SqlHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Food food = new Food();
                food.setF_id(rs.getInt("f_id"));
                food.setF_name(rs.getString("f_name"));
                food.setF_content(rs.getString("f_content"));
                food.setPrice(rs.getInt("price"));
                food.setF_image(rs.getString("f_image"));
                return food;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //菜品名的模糊查询
    public List<Food> findMeu(String key){
        String sql = "select * from food where f_name like ?";
        String[] ps = new String[1];
        ps[0] = "%" + key + "%";
        ResultSet resultSet = SqlHelper.executeQuery(sql, ps);
        List<Food> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Food food = new Food();
                food.setF_id(resultSet.getInt("f_id"));
                food.setF_name(resultSet.getString("f_name"));
                food.setF_content(resultSet.getString("f_content"));
                food.setPrice(resultSet.getInt("price"));
                food.setF_image(resultSet.getString("f_image"));
                list.add(food);
            }

        } catch (Exception er) {
            er.printStackTrace();
        }
        return list;
    }
    //将菜品信息查出来
    public List<Food> findAll(){
        String sql = "select * from food";
        ResultSet resultSet = SqlHelper.executeQuery(sql, null);
        List<Food> list = new ArrayList<>();

        try{
            while (resultSet.next()){
                Food food = new Food();
                food.setF_id(resultSet.getInt("f_id"));
                food.setF_name(resultSet.getString("f_name"));
                food.setF_content(resultSet.getString("f_content"));
                food.setPrice(resultSet.getInt("price"));
                food.setF_image(resultSet.getString("f_image"));

                list.add(food);
            }
        }catch (Exception er){
            er.printStackTrace();
        }
        return list;
    }
}
