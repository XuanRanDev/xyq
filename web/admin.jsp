<%--
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
        <title>后台管理</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/nav.css">
        <link rel="stylesheet" href="css/commons.css">
        <link href="css/public.css" rel="stylesheet" type="text/css"/>

        <style>

            body {
                margin: 0;
            }


            .pg-body .left-menu {
                width: 220px;
                background: #EAEDF1;
                position: fixed;
                top: 48px;
                left: 0;
                bottom: 0;
            }

            .pg-body .right-body {
                position: fixed;
                top: 48px;
                right: 0;
                bottom: 0;
                left: 220px;
                overflow: auto;
            }

            .pg-body .right-container {
                padding: 15px;
            }

            .aaa:hover {
                background: #e3e3e3;
                cursor: pointer;
                font-size: 16px;
                color: black;
            }

            #iframe {
                width: 100%;
                height: 460px;
                /*border-style: none;*/
            }
        </style>
    </head>
    <body>

        <jsp:useBean id="user" scope="session" class="cn.com.scitc.model.User"></jsp:useBean>
        <jsp:useBean id="food" scope="page" class="cn.com.scitc.model.Food"></jsp:useBean>
        <div class="pg-header">
            <div class="nav">
                <div class="logo-area left ">
                    <a href="#">
                        <span style="font-size: 20px;color:black">后台管理</span>
                    </a>
                </div>

                <div class="left-menu left">
                    <c:choose>
                        <c:when test="${user.loginId!=null}">
                            <a href="<c:url value="/tzMain"/>" class="menu-item" target="_blank">前台界面</a>
                        </c:when>
                    </c:choose>
                </div>

                <div class="right-menu right clearfix">

                    <div class="user-info right">
                        <c:choose>
                            <c:when test="${user.loginId!=null}">
                                <span style="color: black">欢迎您：<c:out value="${user.userName}"></c:out></span>
                                <a href="<c:url value="/exitAdmin" />"><span style="color: black">【退出】</span></a>
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
                </div>

            </div>
        </div>
        <div class="pg-body">
            <div class="left-menu">
                <div class="menu-body">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">用户管理</a>
                                </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in">
                                <div class="panel-body aaa" style="text-align: center;">
                                    <a class="aaa" target="frame"
                                       href="${pageContext.request.contextPath}/filterAdmin/adminUser">用户信息</a>
                                </div>
                                <div class="panel-body aaa" style="text-align: center">
                                    <a class="aaa" target="frame" href="<c:url value="/addUser"/>">添加用户</a>
                                </div>
                                <div class="panel-body aaa" style="text-align: center">
                                    <a class="aaa" target="frame" href="<c:url value="/addAdmin"/>">添加管理员</a>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion"
                                                               href="#collapseTwo">菜品管理</a></h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse">
                                    <div class="panel-body aaa" style="text-align: center;">
                                        <a class="aaa" target="frame" href="<c:url value="/food"/>">菜品信息</a>
                                    </div>
                                    <div class="panel-body aaa" style="text-align: center;">
                                        <a class="aaa" target="frame" href="<c:url value="/addFood"/>">添加菜品</a>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion"
                                                               href="#collapseThree">订单管理</a></h4>
                                </div>
                                <div id="collapseThree" class="panel-collapse collapse">
                                    <div class="panel-body aaa" style="text-align: center;">
                                        <a class="aaa" target="frame" href="<c:url value="/orders"/>">订单信息</a>
                                    </div>
                                </div>
                            </div>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion"
                                                               href="#collapseFour">评论管理</a></h4>
                                </div>
                                <div id="collapseFour" class="panel-collapse collapse">
                                    <div class="panel-body aaa" style="text-align: center;">
                                        <a class="aaa" target="frame" href="<c:url value="/adminComment"/>">评论管理</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div class="right-body">
                <div class="right-container">
                    <iframe name="frame" id="iframe" src="<c:url value="/food"/>"></iframe>
                </div>
            </div>
        </div>


        <script src="jquery/jquery.min.js"></script>
        <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            function tc() {
                alert('请先登录！！！');
            }
        </script>
    </body>
</html>
