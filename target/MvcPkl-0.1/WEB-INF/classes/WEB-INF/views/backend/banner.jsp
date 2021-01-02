<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12/27/2020
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>Admin | Banner</title>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Banner</h1>
    </div>
</div>
<div class="row">
    <div class="col-xs-12 col-md-4 col-lg-4">
        <div class="panel panel-primary">
            <div class="panel-heading">Banner</div>
            <div class="panel-body">
                <c:if test="${ not empty msg}">
                    <h1 class="text-center alert-success panel-heading">${msg}</h1>
                </c:if>
                <c:choose>
                    <c:when test="${banner != null}">
                        <form action="/admin/banner/${banner.id}" enctype="multipart/form-data" method="post">
                            <div class="row" style="margin-bottom:40px">
                                <div class="col-xs-8">
                                    <div class="form-group">
                                        <label>Ảnh Banner</label>
                                        <input type="hidden" name="id" value="${banner.id}">
                                        <input id="img" type="file" class="form-control hidden" name="img" onchange="changeImg(this)">
                                        <img id="avatar" class="thumbnail" width="300px"
                                             src="/resources/images/banner/${banner.name}">
                                    </div>
                                    <div class="form-group">
                                        <label>Trạng thái</label><br>
                                        <label for="status">true: </label>
                                        <input type="radio" <c:if test="${banner.status ==true}">checked</c:if> id="status" name="status"
                                               value="true">
                                        &nbsp;
                                        <label for="status1">false: </label>
                                        <input type="radio" id="status1" name="status"  <c:if test="${banner.status ==false}">checked</c:if>
                                               value="false">
                                    </div>
                                    <input type="submit" name="submit" value="Lưu" class="btn btn-primary">
                                </div>
                            </div>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="/admin/banner" enctype="multipart/form-data" method="post">
                            <div class="row" style="margin-bottom:40px">
                                <div class="col-xs-8">
                                    <div class="form-group">
                                        <label>Ảnh Banner</label>
                                        <input id="img" type="file" class="form-control hidden" name="img" onchange="changeImg(this)">
                                        <img id="avatar" class="thumbnail" width="300px"
                                             src="<c:url value='/resources/admin/img/new_seo-10-512.png' />">
                                    </div>
                                    <div class="form-group">
                                        <label>Trạng thái</label><br>
                                        <label for="status">true: </label>
                                        <input type="radio" checked id="status" name="status"
                                               value="true">
                                        &nbsp;
                                        <label for="status1">false: </label>
                                        <input type="radio" id="status1" name="status"
                                               value="false">
                                    </div>
                                    <input type="submit" name="submit" value="Lưu" class="btn btn-primary">
                                </div>
                            </div>
                        </form>
                    </c:otherwise>
                </c:choose>
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
                        <c:forEach var="b" items="${banners}">
                            <tr>
                                <td>
                                    <h5 hidden>${b.name}</h5>
                                    <img style="width: 150px; height: 55px;" alt="banner" src="/resources/images/banner/${b.name}">
                                </td>
                                <td>${b.status}</td>
                                <td>
                                    <a class="btn btn-primary" href="/admin/banner/${b.id}">Edit</a> &nbsp;
                                    <c:url var="delete" value="/admin/banner/delete">
                                        <c:param name="id" value="${b.id}" />
                                    </c:url>
                                    <a class="btn btn-danger" href="${delete}"
                                       onclick="confirm('Bạn có chắc mốn xóa?')">Delete</a>
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
</body>
</html>
