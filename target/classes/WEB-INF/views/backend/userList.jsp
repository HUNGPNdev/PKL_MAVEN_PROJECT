<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/1/2021
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">User</h1>
    </div>
</div>

<div class="col-xs-12 col-md-12 col-lg-12">

    <div class="panel panel-primary">
        <div class="panel-heading">Danh sách User</div>
        <div class="panel-body">
            <div class="bootstrap-table">
                <div class="table-responsive">
                    <div class="form-group">
                        <br><input class="form-control" id="myInput" type="text" placeholder="Search..">
                    </div>
                    <table class="table table-bordered" style="margin-top:20px;">
                        <thead>
                        <tr class="bg-primary">
                            <th>username</th>
                            <th>email</th>
                            <th>fullname</th>
                            <th>address</th>
                            <th>gender</th>
                            <th>Role</th>
                            <th>Tùy chọn</th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                            <c:forEach var="u" items="${users}">
                                <tr>
                                    <td>${u.username}</td>
                                    <td>${u.email}</td>
                                    <td>${u.fullname}</td>
                                    <td>${u.address}</td>
                                    <td>${u.gender}</td>
                                    <td>
                                        <form action="/admin/user-edit-role/${u.user_id}" method="post" style="font-size: 10px;">
                                            <c:forEach var="r" items="${roles}">
                                                <c:set var="isSelected" value="false" />
                                                <c:forEach var="rl" items="${u.roles}">
                                                    <c:if test="${rl.id == r.id}">
                                                        <c:set var="isSelected" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:choose>
                                                    <c:when test="${isSelected}">
                                                        <label><input type="checkbox" name="role_id" checked value="${r.id}">${r.role}</label>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <label><input type="checkbox" name="role_id" value="${r.id}">${r.role}</label>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                            <input type="submit" name="submit" value="Edit" class="btn btn-primary">
                                        </form>
                                    </td>
                                    <td>
                                        <c:url var="delete" value="/admin/deleteUser">
                                            <c:param name="user_id" value="${u.user_id}"/>
                                        </c:url>
                                        <a onclick="confirm('Bạn có chắc muốn xóa?')" class="btn btn-danger" href="${delete}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

