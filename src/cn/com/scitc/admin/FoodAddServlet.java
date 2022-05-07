package cn.com.scitc.admin;

import cn.com.scitc.dao.FoodDao;
import cn.com.scitc.model.Food;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.jspsmart.upload.File.SAVEAS_PHYSICAL;

@WebServlet(name = "FoodAddServlet",urlPatterns = "/filterAdmin/foodAdd")
public class FoodAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletConfig servletConfig;

    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //新建一个SmartUpload对象
            SmartUpload su = new SmartUpload();
            //上传初始化
            su.initialize(servletConfig, request, response);
            //限制每个上传文件的最大长度
            su.setMaxFileSize(1000000 * 1000);
            su.setDeniedFilesList("exe,bat,jsp,htm,html");
            //上传文件
            su.upload();
            //获取上传的文件操作
            Files files = su.getFiles();
            //获取单个文件
            File singleFile = files.getFile(0);
            //获取上传文件的扩展名
            String fileType = singleFile.getFileExt();
            //设置上传文件的扩展名
            String[] type = {"JPG","jpg","png","PNG"};
            // 判断上传文件的类型是否正确
            int place = java.util.Arrays.binarySearch(type, fileType);
            //判断文件扩展名是否正确
            if (place != -1){
                //判断该文件是否被选择
                if (!singleFile.isMissing()){
//					String picSize = String.valueOf(singleFile.getSize());

                    //以系统时间作为上传文件名称，设置上传完整路径
                    String fileName = String.valueOf(System.currentTimeMillis());
                    String filedir =  fileName + "." + singleFile.getFileExt();

                    request.setCharacterEncoding("gbk");
                    //执行上传操作

                    singleFile.saveAs("E:/FoodImg/" + filedir , SAVEAS_PHYSICAL);
                    System.out.println("上传至： " + filedir);
                    String f_name = su.getRequest().getParameter("f_name");
                    String price = su.getRequest().getParameter("price");
                    String f_content = su.getRequest().getParameter("f_content");
                    Food food = new Food();
                    food.setF_name(f_name);
                    food.setF_content(f_content);
                    Integer jg = Integer.parseInt(price);
                    food.setPrice(jg);
                    food.setF_image(filedir);
                    FoodDao dao = new FoodDao();
                    dao.inFood(food);
                    System.out.println("FoodName: " + food.getF_name());
                    System.out.println("menuPrice: " + food.getPrice());
                    System.out.println("menuNotice: " + food.getF_content());
                    System.out.println(food.getF_image());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script language='javascript'>alert('添加成功');</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
