<%@ page import="cn.com.scitc.model.Food" %>
<%@ page import="cn.com.scitc.dao.FoodDao" %>
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
    <link type="text/css" href="css/public.css" rel="stylesheet"/>

    <style>
        #body h2{
            width: 100%;
            text-align: center;
            border-bottom: 1px dashed gainsboro;
            padding-top: 15px;
            padding-bottom: 15px;
        }
        #body .table{
            width: 80%;
            margin: 0 auto;
            text-align: center;
            margin-top: 30px;
        }
        #body .table .td{
            font-weight: bolder;
            width: 133px;
            height: 60px;
            line-height: 60px;
        }
        #body .table .td1{
            font-size: 15px;
        }
        #body .table .td1 a{
            text-decoration: none;
            color: #104E8B;
        }

        #body .span{
            width: 20%;
            float: left;
            margin: 0 auto;
            text-align: center;
            margin-top: 50px;
            font-weight: bolder;
            margin-bottom: 20px;
        }
        #body #span{
            margin-left: 370px;
        }

        #body .button{
            width: 15%;
            margin: 0 auto;
            /*margin-bottom: 150px;*/
            margin-top: 30px;
        }
        #body .button input[type="submit"]{
            width: 100px;
            height: 30px;
            border: none;
            background-color: #ff4500;
            font-size: 15px;
            color: #f5f5f5;
            border-radius: 10px;
        }
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


        .pg-body .right-container {
            padding: 15px;
        }


    </style>
</head>
<body>
<jsp:useBean id="user" class="cn.com.scitc.model.User" scope="session"></jsp:useBean>
<jsp:useBean id="ordersBean" class="cn.com.scitc.model.Orders" scope="page"></jsp:useBean>
<jsp:setProperty property="user" name="ordersBean" value="${user}"/>

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
            <div id="body">
                <h2>您的购物车列表信息：</h2>
                <table class="table table-hover">
                    <tr>
                        <td class="td"><span class="text">编号</span></td>
                        <td class="td"><span class="text">菜名</span></td>
                        <td class="td"><span class="text">数量</span></td>
                        <td class="td"><span class="text">单价</span></td>
                        <td class="td"><span class="text">总价</span></td>
                        <td class="td"><span class="text">备注</span></td>
                        <td class="td"><span class="text">操作</span></td>
                    </tr>
                    <c:choose>
                    <c:when test="${user.loginId!=null}">
                        <jsp:getProperty property="showBuyList" name="ordersBean"/>
                    </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>
                </table>
                <c:choose>
                <c:when test="${user.loginId!=null}">
                    <div class="span" id="span"><span class="num">总数量：</span>
                        <input  type="text" style="width: 70px;" value="<jsp:getProperty property="total" name="ordersBean"/>" disabled></div>
                    <div class="span">
                        总价：
                        <input  type="text" style="width: 70px;" value="<jsp:getProperty property="totalPrice" name="ordersBean"/>" disabled>
                       </div>
                </c:when>
                    <c:otherwise>
                        <div class="span" id="span"><span class="num">总数量：</span><span></span></div>
                        <div class="span"><span>总价：</span><span class="pri"></span></div>
                    </c:otherwise>
                </c:choose>
                <div class="button">
                    <form action="<c:url value="/orderPay"/>" method="get">
                        <div class="button"><input type="submit" value="提交订单"/></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="/Ordering/jquery/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/Ordering/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function tc(){
        alert('请先登录！！！');
    }
</script>
</body>
</html>