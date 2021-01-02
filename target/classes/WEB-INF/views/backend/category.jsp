<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12/30/2020
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Category</h1>
    </div>
</div>
<div class="row">
    <div class="col-xs-12 col-md-4 col-lg-4">
        <div class="panel panel-primary">
            <div class="panel-heading">Banner</div>
            <div class="panel-body">
                <form:form action="/admin/category" modelAttribute="cate" method="post">
                    <div class="row" style="margin-bottom:40px">
                        <div class="col-xs-8">
                            <div class="form-group">
                                <label>Tên danh mục:</label>
                                <form:hidden path="id"/>
                                <form:input path="name" cssClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label>Trạng thái</label><br>
                                <label>True:  <form:radiobutton path="status" value="true"/></label>
                                <label>False: <form:radiobutton path="status" value="false"/></label>
                            </div>
                            <input type="submit" name="submit" value="Lưu" class="btn btn-primary">
                        </div>
                    </div>
                </form:form>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-md-8 col-lg-8">
        <div class="panel panel-primary">
            <div class="panel-heading">Danh sách danh mục</div>
            <div class="panel-body">
                <div class="bootstrap-table">
                    <input class="form-control" id="myInput" type="text" placeholder="Search..">
                    <br>
                    <table class="table table-bordered">
                        <thead>
                        <tr class="bg-primary">
                            <th scope="col">Images</th>
                            <th scope="col">Trạng thái</th>
                            <th scope="col">Tùy chọn</th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                            <c:forEach var="c" items="${categories}">
                                <tr>
                                    <td>${c.name}</td>
                                    <td>${c.status}</td>
                                    <td>
                                        <c:url var="update" value="/admin/category/update">
                                            <c:param name="id" value="${c.id}"></c:param>
                                        </c:url>
                                        <a class="btn btn-primary" href="${update}">Edit</a> &nbsp;
                                        <c:url var="delete" value=""></c:url>
                                        <c:url var="delete" value="/admin/category/delete">
                                            <c:param name="id" value="${c.id}"/>
                                        </c:url>
                                        <a href="${delete}" class="btn btn-danger" onclick="confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
