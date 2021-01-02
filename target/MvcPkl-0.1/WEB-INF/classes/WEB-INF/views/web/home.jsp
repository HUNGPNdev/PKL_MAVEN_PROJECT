<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12/29/2020
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<div id="wrap-inner">
    <div class="products">
        <h3>Sản Phẩm</h3>
        <div class="product-list row">
            <c:forEach var="p" items="${products}">
                <div class="product-item col-md-3 col-sm-6 col-xs-12">
                    <a href="#"><img src="/resources/images/product/${p.image}" class="img-thumbnail"></a>
                    <p><a href="#">${p.name}</a></p>
                    <p class="price">${p.price}</p>
                    <div class="marsk">
                        <a href="/pkl/details/${p.id}">Xem chi tiết</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
