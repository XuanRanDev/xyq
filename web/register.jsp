<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/7/4
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="/Ordering/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div style="width:200px;margin:0 auto;">
    <h1 style="text-align: center;">注册用户</h1>

    <form method="get" action="<c:url value="/reg"/>">
        <div class="form-group" style="margin-top:20px;margin-left: 5px; ">
            <label>账　　　号：</label>
            <input type="text" class="form-control" name="loginId" placeholder="账号" style="width: 200px" required autofocus>
        </div>
        <div class="form-group" style="margin-top:20px;margin-left: 5px;">
            <label >密　　　码：</label>
            <input type="password" class="form-control" name="password" placeholder="密码" style="width: 200px;" required>
        </div>
        <div class="form-group" style="margin-top:20px; margin-left: 5px;">
            <label >用　户　名：</label>
            <input type="text" class="form-control" name="userName" placeholder="用户名" style="width: 200px;" required>
        </div>
        <div class="form-group" style="margin-top:20px; margin-left: 5px;">
            <label >手　机　号：</label>
            <input type="tel" class="form-control" name="mobile" placeholder="手机号" style="width: 200px;" required>
        </div>
        <div class="form-group" style="margin-top:20px; margin-left: 5px;">
            <label >邮　　　箱：</label>
            <input type="email" class="form-control" name="email" placeholder="邮箱" style="width: 200px;" required>
        </div>
        <div class="form-group" style="width:200px;">
            <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        </div>

    </form>

</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/Ordering/jquery/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/Ordering/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>