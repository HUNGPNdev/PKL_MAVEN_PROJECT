<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Sản phẩm</h1>
    </div>
</div>
<div class="row">
    <div class="col-xs-12 col-md-12 col-lg-12">

        <div class="panel panel-primary">
            <div class="panel-heading">Thêm sản phẩm</div>
            <div class="panel-body">
                <form:form action="/admin/product" modelAttribute="product" method="post" enctype="multipart/form-data">
                    <div class="row" style="margin-bottom:40px">
                        <div class="col-xs-8">
                            <div class="form-group" >
                                <label>Tên sản phẩm</label>
                                <form:hidden path="id" />
                                <form:input path="name" cssClass="form-control" />
                            </div>
                            <div class="form-group" >
                                <label>Giá sản phẩm</label>
                                <form:input path="price" cssClass="form-control" />
                            </div>
                            <div class="form-group" >
                                <label>Miêu tả</label>
                                <form:textarea path="details"></form:textarea>
                            </div>
                            <div class="form-group" >
                                <label>Bảo hành</label>
                                <form:input path="guarantee" cssClass="form-control" />
                            </div>
                            <div class="form-group" >
                                <label>Phụ kiện</label>
                                <form:input path="part" cssClass="form-control" />
                            </div>
                            <div class="form-group" >
                                <label>Hỗ trợ</label>
                                <form:input path="support" cssClass="form-control" />
                            </div>
                            <div class="form-group" >
                                <label>Danh mục</label>
                                <form:select path="cate_id" cssClass="form-control">
                                    <c:forEach var="ct" items="${cate}">
                                        <form:option value="${ct.id}">${ct.name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="form-group" >
                                <label>Ảnh sản phẩm</label>
                                <c:choose>
                                    <c:when test="${product.img!='' && product.id != 0}">
                                        <form:input id="img" path="image" type="file" class="form-control hidden" onchange="changeImg(this)" />
                                        <img id="avatar" class="thumbnail" width="300px" src="/resources/images/product/${product.img}">
                                    </c:when>
                                    <c:when test="${product.img==''}">
                                        <form:input id="img" name="image" path="image" type="file" class="form-control hidden" onchange="changeImg(this)" />
                                        <img id="avatar" class="thumbnail" width="300px" src="/resources/admin/img/new_seo-10-512.png">
                                    </c:when>
                                    <c:otherwise>
                                        <form:input id="img" name="image" path="image" type="file" class="form-control hidden" onchange="changeImg(this)" />
                                        <img id="avatar" class="thumbnail" width="300px" src="/resources/admin/img/new_seo-10-512.png">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="form-group">
                                <label>Trạng thái</label><br>
                                <label>True:  <form:radiobutton path="status" value="true"/></label>
                                <label>False: <form:radiobutton path="status" value="false"/></label>
                            </div>
                            <input type="submit" name="submit" value="Thêm" class="btn btn-primary">&nbsp;
                            <a href="/admin/product-list" class="btn btn-danger">Hủy bỏ</a>
                        </div>
                    </div>
                </form:form>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
