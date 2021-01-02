<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/2/2021
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Danh sách đơn đặt hàng</h1>
    </div>
</div>

<div class="col-xs-12 col-md-12 col-lg-12">

    <div class="panel panel-primary">
        <div class="panel-heading">Danh sách đơn đặt hàng</div>
        <div class="panel-body">
            <div class="bootstrap-table">
                <div class="table-responsive">
                    <div class="form-group">
                        <br><input class="form-control" id="myInput" type="text" placeholder="Search..">
                    </div>
                    <table class="table table-bordered" style="margin-top:20px;">
                        <thead>
                        <tr class="active">
                            <td scope="col">Ảnh mô tả</td>
                            <td scope="col">Tên sản phẩm</td>
                            <td scope="col">Tên người dùng</td>
                            <td scope="col">Số lượng</td>
                            <td scope="col">Đơn giá</td>
                            <td scope="col">Thành tiền</td>
                            <td scope="col">Thao tác</td>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        <c:forEach var="p" items="${orderList}">
                            <tr>
                                <td><img style="width: 125px;" class="img-responsive" src="/resources/images/product/${p.img}"></td>
                                <td>${p.pro_name}</td>
                                <td>${p.username}</td>
                                <td>${p.quantity}</td>
                                <td><span class="price">${p.price} $</span></td>
                                <td><span class="price">${p.price * p.quantity} $</span></td>
                                <c:url var="delete" value="/admin/order-delete">
                                    <c:param name="id" value="${p.id}"/>
                                </c:url>
                                <td>
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

