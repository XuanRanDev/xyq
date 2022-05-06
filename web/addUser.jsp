<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/17
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>后台管理</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="width:510px;margin: 0 auto;">
    <h1 style="text-align: center;">添加用户</h1>

    <form method="get" action="http://localhost:8080/Demo/filterAdmin/userAdd" class="form-inline">
        <div class="form-group" style="margin-top:20px;margin-left: 5px; ">
            <label>账 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
            <input type="text" class="form-control" name="loginId" placeholder="账号" style="width: 170px;" required autofocus>

        </div>
        <div class="form-group" style="margin-top:20px;margin-left: 5px;">
            <label >密 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
            <input type="password" class="form-control" name="password" placeholder="密码" style="width: 170px;" required>
        </div>
        <div class="form-group" style="margin-top:20px; margin-left: 5px;">
            <label >姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
            <input type="text" class="form-control" name="userName" placeholder="姓名" style="width: 170px;" required>
        </div>
        <div class="form-group" style="margin-top:20px; margin-left: 5px;">
            <label >手机号码：</label>
            <input type="tel" class="form-control" name="mobile" placeholder="手机号码" style="width: 170px;" required>
        </div>
        <div class="form-group" style="margin-top:20px;margin-left: 5px; ">
            <label >权 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限：</label>
            <select class="form-control" style="width: 170px;" name="u_flag"  >
                <option >普通用户</option>
                <option >管理员</option>
            </select>
        </div>
        <div class="form-group" style="margin-top:20px;margin-left: 5px; ">
            <label >邮 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
            <input type="email" class="form-control" name="email" placeholder="邮箱" style="width: 170px;" required>
        </div>
        <div class="form-group" style="width:100px;margin-left:220px;margin-top: 20px;">
            <button class="btn btn-lg btn-primary btn-block" type="submit">添加</button>
        </div>

    </form>
    <script src="jquery/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</div>
</body>
</html>
