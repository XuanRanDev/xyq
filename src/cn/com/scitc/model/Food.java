package cn.com.scitc.model;

import cn.com.scitc.dao.FoodDao;

import java.util.List;

public class Food {

    private Integer f_id;
    private String f_name;
    private String f_content;
    private Integer price;
    private String f_image;
    private StringBuffer showMenuList;		//列出菜单

    public String getF_content() {
        return f_content;
    }

    public void setF_content(String f_content) {
        this.f_content = f_content;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getF_image() {
        return f_image;
    }

    public void setF_image(String f_image) {
        this.f_image = f_image;
    }
    public StringBuffer getShowMenuList() {
        FoodDao dao = new FoodDao();
        List<Food> list = dao.findAll();
        showMenuList = new StringBuffer();
        for (Food food : list) {
            showMenuList.append("<li class=\"content\"><figure class=\"fig\"><img src=\"images/");
            showMenuList.append(food.getF_image() + ".jpg\" width=\"200px\" class=\"img\"/>");
            showMenuList.append("<figcaption class=\"describe\">");
            showMenuList.append("<p class=\"name\">" + food.getF_name() + "</p>");
            showMenuList.append("<p class=\"price\"><span class=\"sign\">￥</span><span class=\"current\">");
            showMenuList.append(food.getPrice());
            showMenuList.append("/份</span></p><div class=\"buying\"><a href=\"information.jsp?id=" + food.getF_id() + "\">加入购物车</a></div></figcaption></figure></li>");

//			<li class="content">
//            <figure class="fig">
//                <img src="images/1.jpg" width="200px" class="img"/>
//                <figcaption class="describe">
//                    <p class="name">图片</p>
//                    <p class="price">
//                        <span class="sign">￥</span>
//                        <span class="current">19/份</span>
//                    </p>
//                    <div class="buying">
//                        <a href="information.jsp?id=1">加入购物车</a>
//                    </div>
//                </figcaption>
//            </figure>
//        </li>
        }
        return showMenuList;
    }
}
