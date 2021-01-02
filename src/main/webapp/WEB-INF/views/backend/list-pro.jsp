<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Sản phẩm</h1>
    </div>
</div>

<div class="col-xs-12 col-md-12 col-lg-12">

    <div class="panel panel-primary">
        <div class="panel-heading">Danh sách sản phẩm</div>
        <div class="panel-body">
            <div class="bootstrap-table">
                <div class="table-responsive">
                    <a href="/admin/product" class="btn btn-primary">Thêm sản phẩm</a>
                    <div class="form-group">
                        <br><input class="form-control" id="myInput" type="text" placeholder="Search..">
                    </div>
                    <table class="table table-bordered" style="margin-top:20px;">
                        <thead>
                        <tr class="bg-primary">
                            <th>Tên Sản phẩm</th>
                            <th>Giá sản phẩm</th>
                            <th>Chi tiết</th>
                            <th>Bảo hành</th>
                            <th>phụ kiện</th>
                            <th>Hỗ trợ</th>
                            <th>Ảnh sản phẩm</th>
                            <th>Trạng thái</th>
                            <th>Danh mục</th>
                            <th>Tùy chọn</th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                            <c:forEach var="p" items="${products}">
                                <tr>
                                    <td>${p.name}</td>
                                    <td>${p.price}</td>
                                    <td>${p.details}</td>
                                    <td>${p.guarantee}</td>
                                    <td>${p.part}</td>
                                    <td>${p.support}</td>
                                    <td>
                                        <img alt="${p.image}" src="/resources/images/product/${p.image}" style="width: 120px; height: 90px;">
                                    </td>
                                    <td>${p.category.name}</td>
                                    <td>${p.status}</td>
                                    <c:url var="update" value="/admin/product-update">
                                        <c:param name="id" value="${p.id}"/>
                                    </c:url>
                                    <c:url var="delete" value="/admin/product-delete">
                                        <c:param name="id" value="${p.id}"/>
                                    </c:url>
                                    <td>
                                        <a class="btn btn-primary" href="${update}">Update</a>
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
