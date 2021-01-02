<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/1/2021
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.jpg">
    <link href="<c:url value='/resources/web/css/bootstrap.min.css' />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value='/resources/web/js/jquery-3.2.1.min.js' />"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="<c:url value='/resources/web/js/bootstrap.min.js'/>"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style type="text/css" media="screen">
        #bodyLogin {
            width: 350px;
            margin: 110px auto;
        }
        body {
            background-image: url('/resources/images/hinh.png') !important;
            height: 100%;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body onload='document.f.username.focus();'>
<div id="bodyLogin">
    <security:authorize access="isAuthenticated()">
        <c:redirect url="/pkl/home"/>
    </security:authorize>
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            <p>Invalid username and password.</p>
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            <p>You have been logged out successfully.</p>
        </div>
    </c:if>
    <c:if test="${ not empty msg}">
        <h1 class="text-center alert-success panel-heading" style="font-size: 16px;padding: 20px;}">${msg}</h1>
    </c:if>
    <h3>Login with Username and Password</h3>
    <form name='f' action='/login' method='POST'>
        <table>
            <tr><td>User:</td><td><input type='text' name='username' value=''></td></tr>
            <br>
            <tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
            <tr><td>&nbsp;&nbsp;</td><td><a href="/account/regis">Đăng ký?</a></td></tr>
            <tr><td colspan='2'>
                <input name="submit" class="btn btn-primary" type="submit" value="Login"/>
            </td></tr>

        </table>
    </form>
</div>
</body>
</html>
