<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/7/4
  Time: 14:12
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
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

</head>
<body>
    <div class="container" style="width: 300px;">

        <form action="<c:url value="/usr" /> " method="post">
            <h2 style="text-align: center">菜鸟订餐</h2>
            <label  >账号：</label>
            <input type="text"  class="form-control"  name="loginId" placeholder="账号"   required autofocus>
            <label  >密码：</label>
            <input type="password"  class="form-control"  name="password" placeholder="密码" required>
            <div>
                　
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
                 <div style="text-align: right;">
                     <a href="<c:url value="/selePwd"/>" style="text-align: right;">忘记密码</a>
                    <span>　　　　　还没有账号？</span><a href="<c:url value="/register"/> ">立即注册</a>
                </div>

        </form>

    </div> <!-- /container -->

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/Ordering/jquery/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/Ordering/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>