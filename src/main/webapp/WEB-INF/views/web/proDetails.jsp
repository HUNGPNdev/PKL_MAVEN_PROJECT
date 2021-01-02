<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 1/1/2021
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="wrap-inner">
    <div id="product-info">
        <div class="clearfix"></div>
        <h3>${p.name}</h3>
        <div class="row">
            <div id="product-img" class="col-xs-12 col-sm-12 col-md-3 text-center">
                <img src="/resources/images/product/${p.img}" style="width: 260px;">
            </div>
            <div class="col-md-1">
            </div>
            <div id="product-details" class="col-xs-12 col-sm-12 col-md-8">
                <p>Giá: <span class="price">${p.price} $</span></p>
                <p>Bảo Hành: ${p.guarantee}</p>
                <p>Phụ kiện: ${p.part}</p>
                <p>Hỗ trợ: ${p.support}</p>
                <p>Khuyến mại: ${p.price}</p>
                <p>Hãng Xe: ${p.price}</p>
                <p>Tình trạng:
                </p>
                <c:url var="cart" value="/pkl/cart">
                    <c:param name="id" value="${p.id}"/>
                    <c:param name="name" value="${p.name}"/>
                    <c:param name="price" value="${p.price}"/>
                    <c:param name="img" value="${p.img}"/>
                </c:url>
                <p class="add-cart text-center"><a style="color: #FFF;" href="${cart}">Thêm vào giỏ hàng</a></p>
            </div>
        </div>
    </div>
    <div id="product-detail">
        <h3>Chi tiết sản phẩm</h3>
        <p class="text-justify">${p.details}.</p>
    </div>
<%--    <div id="comment-list">--%>
<%--        <div class="fb-comments" data-href="https://www.facebook.com/minhlongmoto/posts/892083137995906" data-width="825" data-numposts="5"></div>--%>
<%--    </div>--%>
</div>
