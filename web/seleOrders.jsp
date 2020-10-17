<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/17
  Time: 12:45
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

<div >
    <div style="text-align:center;margin:0 auto;"><span style="font-size: 50px;">所有订单</span></div>
    <div style="margin-left: 690px;">
        <form method="get" action="<c:url value="/seleOrders"/>">
            <input type="text" name="key" value="<c:out value="${param.key}" />"/>
            <input type="submit" value="查询" />
        </form>
    </div>
    <table class="table table-hover table-bordered">
        <tr>
            <td style="text-align: center;font-weight: bold">用户ID</td>
            <td style="text-align: center;font-weight: bold">菜名</td>
            <td style="text-align: center;font-weight: bold">数量</td>
            <td style="text-align: center;font-weight: bold">总价格</td>
            <td style="text-align: center;font-weight: bold">备注</td>
            <td style="text-align: center;font-weight: bold">付款方式</td>
            <td style="text-align: center;font-weight: bold">配送状态</td>
            <td style="text-align: center;font-weight: bold">联系方式</td>
            <td style="text-align: center;font-weight: bold">操作</td>
        </tr>
        <c:forEach items="${o_list}" var="orders" >
            <tr>
                <td style="text-align: center;"><c:out value="${orders.loginId}" /></td>
                <td style="text-align: center;"><c:out value="${orders.f_name}" /></td>
                <td style="text-align: center;"><c:out value="${orders.o_num}" /></td>
                <td style="text-align: center;"><c:out value="${orders.num}" /></td>
                <td style="text-align: center;"><c:out value="${orders.markup}" /></td>
                <td style="text-align: center;"><c:out value="${orders.state}" /></td>
                <td style="text-align: center;">
                    <c:if test="${orders.pzstate=='正在配送'}">
                        <c:out value="${orders.pzstate}"/>
                    </c:if>
                    <c:if test="${orders.pzstate=='等待配送'}">
                        <c:out value="${orders.pzstate}"/><br>
                        <a href="<c:url value="/editOrders?id=${orders.o_id}"/>">立即配送</a>
                    </c:if>
                </td>

                <td style="text-align: center;"><c:out value="${orders.mobile}" /></td>
                <td style="text-align: center;">
                    <a href="<c:url value="/delOrders?id=${orders.o_id}"/>" onclick = "return confirm('是否要删除?')">
                        <span class = "glyphicon glyphicon-trash"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="/Ordering/jquery/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="/Ordering/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
