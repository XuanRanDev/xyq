package cn.com.scitc.dao;

import cn.com.scitc.model.Comment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    /*
    * 添加评论
    * */
    public boolean addComment(Comment comment){
        String sql = "insert into comment(loginId,c_xinxi,time) values(?,?,?)";
        Object[] ps = new Object[3];
        ps[0] = comment.getLoginId();
        ps[1] = comment.getC_xinxi();
        ps[2] = comment.getTime();
        SqlHelper.executeUpdate(sql, ps);
        return true;
    }
    /*
    * 删除评论
    * */
    public boolean delByCid(Integer id){
        String sql = "delete from comment where c_id = ?";
        Object[] ps = new Object[1];
        ps[0] = id.toString();
        SqlHelper.executeUpdate(sql, ps);
        return true;
    }
    /*
    * 所有评论信息
    * */
    public List<Comment> findAllCom(){
        String sql = "select * from comment";
        ResultSet resultSet = SqlHelper.executeQuery(sql, null);
        List<Comment> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setC_id(resultSet.getInt("c_id"));
                comment.setLoginId(resultSet.getString("loginId"));
                comment.setC_xinxi(resultSet.getString("c_xinxi"));
                comment.setTime(resultSet.getDate("time"));
                list.add(comment);
            }
        } catch (Exception er) {
            er.printStackTrace();
        }
        return list;
    }
}
