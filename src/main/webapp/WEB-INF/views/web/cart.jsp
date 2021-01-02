<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/1/2021
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div id="wrap-inner">
    <div id="list-cart">
        <h3 class="alert alert-dark text-center" style="margin: 20px;">Giỏ hàng</h3>
        <form>
            <table class="table table-bordered .table-responsive text-center">
                <tr class="active">
                    <td scope="col" width="11.111%">Ảnh mô tả</td>
                    <td scope="col" width="22.222%">Tên sản phẩm</td>
                    <td scope="col" width="22.222%">Số lượng</td>
                    <td scope="col" width="16.6665%">Đơn giá</td>
                    <td scope="col" width="16.6665%">Thành tiền</td>
                    <td scope="col" width="11.112%">Xóa</td>
                </tr>
                <c:set var="total" value="${0}"/>
                <c:forEach var="c" items="${cartList}" >
                    <tr>
                        <td><img style="width: 125px;" class="img-responsive" src="/resources/images/product/${c.img}"></td>
                        <td>${c.name}</td>
                        <td>${c.quantity}</td>
                        <td><span class="price">${c.price} $</span></td>
                        <td><span class="price">${c.price * c.quantity} $</span></td>
                        <c:set var="total" value="${total + c.price * c.quantity}"/>
                        <td><a href="/pkl/cartDelete/${c.pro_id}">Xóa</a></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="row" id="total-price">
                <div class="col-md-6 col-sm-12 col-xs-12">
                    Tổng thanh toán: <span class="total-price">${total} $</span>

                </div>
                <div class="col-md-6 col-sm-12 col-xs-12">
                    <security:authorize access="isAnonymous()">
                        <a class="my-btn btn">Vui lòng đăng nhập để đặt hàng!</a>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <a href="/pkl/order" class="my-btn btn">Đặt Hàng</a>
                    </security:authorize>
                    <a href="/pkl/cartDeleteAll" class="my-btn btn">Xóa giỏ hàng</a>
                </div>
            </div>
        </form>
        <c:if test="${ not empty orderList}">
            <h3 class="alert alert-dark text-center" style="margin: 20px;">ĐƠn hàng đã đặt</h3>
            <table class="table table-bordered .table-responsive text-center">
                <tr class="active">
                    <td scope="col" width="11.111%">Ảnh mô tả</td>
                    <td scope="col" width="22.222%">Tên sản phẩm</td>
                    <td scope="col" width="22.222%">Số lượng</td>
                    <td scope="col" width="16.6665%">Đơn giá</td>
                    <td scope="col" width="16.6665%">Thành tiền</td>
                </tr>
                <c:forEach var="p" items="${orderList}" >
                    <tr>
                        <td><img style="width: 125px;" class="img-responsive" src="/resources/images/product/${p.img}"></td>
                        <td>${p.pro_name}</td>
                        <td>${p.quantity}</td>
                        <td><span class="price">${p.price} $</span></td>
                        <td><span class="price">${p.price * p.quantity} $</span></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
