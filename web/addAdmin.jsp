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
    <form method="get" action="<c:url value="/adminAdd"/>" class="form-inline">
        <div style="margin:0 auto;width: 200px;height: 800px;">
            <h1 style="text-align: center;">添加权限</h1>
                <div class="form-group" style="margin-top:20px;">
                    <label >账 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                    <select class="form-control" style="width: 170px;" name="loginId">
                        <c:forEach items="${listFlag}" var="user">
                            <option value="<c:out value="${user.loginId}"/>"><c:out value="${user.loginId}"/></option>
                        </c:forEach>
                    </select>
                </div>

                    <button class="btn btn-lg btn-primary btn-block" style="margin-top: 10px;" type="submit">添加管理员</button>
                </div>
    </form>
    <script src="jquery/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</div>
</body>
</html>
