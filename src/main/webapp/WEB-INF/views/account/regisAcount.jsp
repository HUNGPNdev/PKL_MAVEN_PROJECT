<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/1/2021
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <c:if test="${ not empty msg}">
        <h1 class="text-center alert-success panel-heading" style="font-size: 16px;padding: 20px;}">${msg}</h1>
    </c:if>
    <form:form action="/account/regis" method="post" modelAttribute="user">
        <div class="form-group">
            <label>User Name</label>
            <form:hidden path="user_id" />
            <form:input path="username" type="text" class="form-control" placeholder="User Name.." required="required" />
        </div>
        <div class="form-group">
            <label>Email address</label>
            <form:input path="email" type="text" class="form-control" placeholder="Email.." required="required" />
        </div>
        <div class="form-group">
            <label>Full Name</label>
            <form:input path="fullname" type="text" class="form-control" placeholder="Full Name.." />
        </div>
        <div class="form-group">
            <label>Address</label>
            <form:input path="address" type="text" class="form-control" placeholder="address.." />
        </div>
        <div class="form-group">
            <label>Password</label>
            <form:input path="password" type="password" class="form-control" placeholder="Password.." />
        </div>
        <div class="form-group">
            <label>Giới tính</label><br>
            <label>Name:  <form:radiobutton path="gender" value="true"/></label>
            <label>Nữ: <form:radiobutton path="gender" value="false"/></label>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="/pkl/home" class="btn btn-danger">Hủy bỏ</a>
    </form:form>
</div>
</body>
</html>
