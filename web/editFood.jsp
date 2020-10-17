<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/17
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- ����3��meta��ǩ*����*������ǰ�棬�κ��������ݶ�*����*������� -->
    <title>��̨����</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="width:510px;margin: 0 auto;">

    <form method="post" action="<c:url value="/foodEdit"/>" enctype="multipart/form-data" >
        <div style="margin:0 auto;width: 430px;height: 800px;">
            <h2 style="text-align: center">�޸Ĳ�Ʒ��Ϣ</h2>
            <div class="form-group" style="margin-top:20px;">
                <label for="exampleInputFile">ͼ������Ƭ��</label>
                <input type="file" id="exampleInputFile"  name="food.f_image" style="display: inline-block;" value="<c:out value="${food.f_image}"/>">
                <p class="help-block" style="text-align: center;display: inline-block">��֧��.jpg��ʽ.</p>
            </div>
            <div class="form-group" style="margin-top:20px;">
                <label>�ˡ���������</label>
                <input type="text" class="form-control" name="f_name" value="<c:out value="${food.f_name}"/>" style="width: 200px;display: inline-block;" required>
            </div>
            <div class="form-group" style="margin-top:20px;">
                <label >�ۡ�������</label>
                <button type="button" id="subtract">-</button>
                <input type="text" class="form-control" name="price" id="text" value="<c:out value="${food.price}"/>" style="width: 50px;display: inline-block;" required >��
                <button type="button" id="plus">+</button>
            </div>
            <div class="form-group" style="margin-top:20px;">
                <label >�顡�����ܣ�</label>
                <textarea class="form-control"name="f_content" rows="3" >${food.f_content}</textarea>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">�޸�</button>
            <input type="hidden" name="id" value="<c:out value="${food.f_id}" />">
        </div>
    </form>
    <script src="jquery/jquery.min.js"></script>
    <!-- ���� Bootstrap ������ JavaScript �������Ҳ���Ը�����Ҫֻ���ص�������� -->
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</div>
<script>
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
</body>
</html>
