<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="content-Type" charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台登录系统</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="particles-js">
    <div class="login">
        <form action="<c:url value="/loginAdmin"/>" method="post">
            <div class="login-top">
                菜鸟订餐后台登录
            </div>
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="images/name.png"></div>
                <div class="login-center-input">
                    <input type="text" name="loginId"  placeholder="请输入您的用户名" onfocus="this.placeholder=''"
                           onblur="this.placeholder='请输入您的用户名'">
                    <div class="login-center-input-text">用户名</div>
                </div>
            </div>
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="images/password.png"></div>
                <div class="login-center-input">
                    <input type="password" name="password" value="" placeholder="请输入您的密码" onfocus="this.placeholder=''"
                           onblur="this.placeholder='请输入您的密码'">
                    <div class="login-center-input-text">密码</div>
                </div>
            </div>
            <div style="text-align: center">
                <button class="login-button">登录</button>
            </div>
        </form>
    </div>
    <div class="sk-rotating-plane"></div>
    <canvas class="particles-js-canvas-el" width="1343" height="202" style="width: 100%; height: 100%;"></canvas>
</div>

<script src="jquery/particles.min.js"></script>
<script src="jquery/app.js"></script>
<script type="text/javascript">
    function hasClass(elem, cls) {
        cls = cls || '';
        if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
        return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
    }

    function addClass(ele, cls) {
        if (!hasClass(ele, cls)) {
            ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
        }
    }

    function removeClass(ele, cls) {
        if (hasClass(ele, cls)) {
            var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
            while (newClass.indexOf(' ' + cls + ' ') >= 0) {
                newClass = newClass.replace(' ' + cls + ' ', ' ');
            }
            ele.className = newClass.replace(/^\s+|\s+$/g, '');
        }
    }

    document.querySelector(".login-button").onclick = function () {
        addClass(document.querySelector(".login"), "active")
        setTimeout(function () {
            addClass(document.querySelector(".sk-rotating-plane"), "active")
            document.querySelector(".login").style.display = "none"
        }, 800)

    }

</script>

</body>
</html>