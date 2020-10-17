<%@ page import="cn.com.scitc.model.Food" %>
<%@ page import="cn.com.scitc.dao.FoodDao" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/8/26
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜鸟订餐</title>
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/nav.css">
    <link rel="stylesheet" href="css/commons.css">

    <style>

        body {
            margin: 0;
        }


        .pg-body .left-menu {
            width:220px;
            background:#EAEDF1;
            position: fixed;
            top:48px;
            left:0;
            bottom: 0;
        }
        .pg-body .right-body {
            position: fixed;
            top:48px;
            right:0;
            bottom: 0;
            left:220px;
            overflow: auto;
        }

        .pg-body .right-container {
            padding: 15px;
        }


    </style>
</head>
<body>


<div class="pg-header">
    <div class="nav">
        <div class="logo-area left ">
            <a href="#">
                <span style="font-size: 20px;color:black">菜鸟订餐</span>
            </a>
        </div>

        <div class="left-menu left">
            <c:choose>
                <c:when test="${user.loginId!=null}">
                    <a href="<c:url value="/main"/>" class="menu-item">菜品信息</a>
                    <a href="<c:url value="/shopping"/>" class="menu-item">我的购物车</a>
                    <a href="<c:url value="/order_search"/>" class="menu-item">订单查询</a>
                    <a href="<c:url value="/comment"/>" class="menu-item">评论</a>
                    <div class="menu-item">
                        <span>个人信息</span>
                        <i class="fa fa-caret-down" aria-hidden="true"></i>
                        <div class="more-info">
                            <a href="<c:url value="/editUser"/>" class="more-item">修改个人信息</a>
                            <a href="<c:url value="/editPassword"/>" class="more-item">修改密码</a>
                            <a href="<c:url value="/selePwd"/>" class="more-item">找回密码</a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="/main"/>" class="menu-item">菜品信息</a>
                    <a href="#" class="menu-item" onclick="return tc()">我的购物车</a>
                    <a href="#" class="menu-item" onclick="return tc()">订单查询</a>
                    <a href="<c:url value="/comment"/>" class="menu-item">评论</a>
                    <div class="menu-item">
                        <span>个人信息</span>
                        <i class="fa fa-caret-down" aria-hidden="true"></i>
                        <div class="more-info">
                            <a href="#" class="more-item" onclick="return tc()">修改个人信息</a>
                            <a href="#" class="more-item" onclick="return tc()">修改密码</a>
                            <a href="<c:url value="/selePwd"/>" class="more-item">找回密码</a>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="right-menu right clearfix">

            <div class="user-info right">
                <!----
                <a href="#" class="avatar" style="color: #0f0f0f">
                    欢迎你:${sessionScope.loginId}
                </a>
                   ---->
                <c:choose>
                    <c:when test="${user.loginId!=null}">
                        <span style="color: black">欢迎您：<c:out value="${user.userName}"></c:out></span>
                        <a href="<c:url value="/exit" />"><span style="color: black">【退出】</span></a>
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value="/login" />"><span style="color: black">【登录】</span></a>
                        <a href="<c:url value="/register" />"><span style="color: black">【注册】</span></a>
                    </c:otherwise>
                </c:choose>
                <!------
                <div class="more-info">
                    <a href="#" class="more-item">个人信息</a>
                    <a href="<c:url value="/login" />" class="more-item">注销</a>
                </div>
                ---->

            </div>
            <!------
            <a class="user-menu right">
                消息
                <i class="fa fa-commenting-o" aria-hidden="true"></i>
                <span class="badge bg-success">2</span>
            </a>

            <a class="user-menu right">
                通知
                <i class="fa fa-envelope-o" aria-hidden="true"></i>
                <span class="badge bg-success">2</span>
            </a>

            <a class="user-menu right">
                任务
                <i class="fa fa-bell-o" aria-hidden="true"></i>
                <span class="badge bg-danger">4</span>
            </a>
             ----->
        </div>

    </div>
</div>
<div class="pg-body">
    <div class="right-body">
        <div class="right-container">
            <%
                //获取菜品信息
                FoodDao dao = new FoodDao();
                Food food = dao.searchById(Integer.parseInt(request.getParameter("id")));
            %>
            <div id="body">
                <h2><span style="color: red;"><%=food.getF_name() %> </span>详细信息 欢迎选购</h2>
                <div class="left"><img src="img/<%=food.getF_image()%>.jpg" style="width: 140px;height: 150px;"/></div>
                <form class="form" action="<c:url value="/addOrder"/>" method="get" onsubmit="return validateForm()">
                    <input type="hidden" name="id" value="<%=food.getF_id() %>">
                    <table class="table">
                        <tr class="tr">
                            <td class="text">菜品单价：</td>
                            <td class="td">￥<%=food.getPrice()%>元</td>
                        </tr>
                        <tr class="tr">
                            <td class="text">菜品简介：</td>
                            <td class="td"><%=food.getF_content()%></td>
                        </tr>
                        <tr class="tr">
                            <td class="text">付款方式：</td>
                            <td class="td">货到付款</td>
                        </tr>
                        <tr class="tr">
                            <td class="text">选购数量：</td>
                            <td class="td">
                                <button type="button" id="subtract">-</button>
                                <input type="text" name="num" id="text"  value="1" style="width: 30px;" required >份
                                <button type="button" id="plus">+</button>
                            </td>
                        </tr>
                        <tr class="tr">
                            <td class="text">备注：</td>
                            <td class="td">
                                <textarea name="markup" id="noticeTextarea"></textarea>
                            </td>
                        </tr>
                    </table>
                    <c:choose>
                        <c:when test="${user.loginId!=null}">
                            <input type="submit" value="加入购物车" name="提交"/>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value="/login"/>"><span>【登录】</span></a>
                        </c:otherwise>
                    </c:choose>
                </form>
                <%-- <div class="rate">用户评价</div>
                <ul class="ul">
                    <jsp:getProperty property="showMessageList" name="messageBean"/>
                </ul> --%>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    function validateForm(){
        var text = document.getElementById('text').value;
        if (text <= 0){
            alert("请正确填写数量！");
            return false;
        }
    }
        function tc(){
            alert('请先登录！！！');
        }
    window.onload = function(){
        var plus = document.getElementById("plus");
        var i = document.getElementById("text").value;
        var subtract = document.getElementById("subtract");
        plus.onclick = function(){
            i++;
            document.getElementById("text").value = i;
        }
        subtract.onclick = function(){
            if (i>0) {
                i--;
                document.getElementById("text").value = i;
            } else{
                i=0;
                document.getElementById("text").value = i;
            }
        }
    }
</script>

<script src="/Ordering/jquery/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/Ordering/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>