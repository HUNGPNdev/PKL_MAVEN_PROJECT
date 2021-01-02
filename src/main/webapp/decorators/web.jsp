<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html" ; charset="UTF-8">
    <title>${title}</title>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.jpg">
    <link href="<c:url value='/resources/web/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/web/css/home.css' />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value='/resources/web/js/jquery-3.2.1.min.js' />"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="<c:url value='/resources/web/js/bootstrap.min.js'/>"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<!-- header -->
<header id="header">
    <div class="container">
        <div class="row">
            <div id="logo" class="col-md-3 col-sm-12 col-xs-12">
                <h1>
                    <a href="/pkl/home"><img width="120" src="/resources/images/logo4.png"></a>
                    <nav><a id="pull" class="btn btn-danger" href="#">
                        <i class="fa fa-bars"></i>
                    </a></nav>
                </h1>
            </div>
            <div id="search" class="col-md-7 col-sm-12 col-xs-12">
            </div>
            <div id="cart" class="col-md-2 col-sm-12 col-xs-12">
                <a class="dropdown-toggle fa fa-user-o"  data-toggle="dropdown" href="#"></a>&nbsp;&nbsp;&nbsp;
                <ul class="dropdown-menu">
                    <security:authorize access="isAnonymous()">
                        <li><a class="fa fa-sign-in" href="/login">&emsp;Sign-In</a></li>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <li><a class="fa fa-address-card-o" href="/account/edit">&emsp;Edit Account</a></li>
                        <li><a class="fa fa-sign-out" href="/logout">&emsp;Sign Out</a></li>
                    </security:authorize>
                </ul>
                <a href="/pkl/shopping" class="display" routerLink="shopping-cart" style="margin-left: 32px; padding: 8px;">
                    <c:if test="${ not empty count}">
                        ${count}
                    </c:if>
                </a>
            </div>
        </div>
    </div>
</header><!-- /header -->
<!-- endheader -->

<!-- main -->
<section id="body">
    <div class="container">
        <div class="row">
            <div id="sidebar" class="col-md-3">
                <nav id="menu">
                    <ul>
                        <li class="menu-item">danh mục sản phẩm</li>
                        <c:forEach var="c" items="${categories}">
                            <c:url var="cate" value="/pkl/getProByCate_id">
                                <c:param name="id" value="${c.id}"/>
                            </c:url>
                            <li class="menu-item"><a href="${cate}">${c.name}</a></li>
                        </c:forEach>
                    </ul>
                </nav>

                <div id="banner-l" class="text-center">
                    <c:forEach var="b" items="${banners}">
                        <div class="banner-l-item">
                            <a href="#"><img src="/resources/images/banner/${b.name}" alt="" class="img-thumbnail"></a>
                        </div>
                    </c:forEach>
                </div>
            </div>


<%--            src="/resources/images/banner/banner3.jpg" --%>

            <div id="main" class="col-md-9">
                <!-- main -->
                <!-- phan slide la cac hieu ung chuyen dong su dung jquey -->
                <div id="slider">
                    <div id="demo" class="carousel slide" data-ride="carousel">
                        <ul class="carousel-indicators">
                            <li data-target="#demo" data-slide-to="0" class="active"></li>
                            <li data-target="#demo" data-slide-to="1"></li>
                            <li data-target="#demo" data-slide-to="2"></li>
                        </ul>
                        <div class="carousel-inner">
                            <c:set var="count" value="0"/>
                            <c:forEach var="b" items="${banners}">
                                <c:if test="${count < 1}">
                                    <div class="carousel-item active">
                                        <img style="width: 848px; height: 350px;"
                                             src="/resources/images/banner/${b.name}" alt="Los Angeles" >
                                    </div>
                                </c:if>
                                <c:if test="${count > 0}">
                                    <div class="carousel-item">
                                        <img style="width: 848px; height: 350px;" src="/resources/images/banner/${b.name}" alt="Image" >
                                    </div>
                                </c:if>
                                <c:set var="count" value="${count + 1}" />
                            </c:forEach>
                        </div>

                        <!-- Left and right controls -->
                        <a class="carousel-control-prev" href="#demo" data-slide="prev">
                            <span class="carousel-control-prev-icon"></span>
                        </a>
                        <a class="carousel-control-next" href="#demo" data-slide="next">
                            <span class="carousel-control-next-icon"></span>
                        </a>
                    </div>
                </div>


                <dec:body/>


                <!-- end main -->
            </div>
        </div>
    </div>
</section>
<!-- endmain -->

<!-- footer -->
<footer id="footer">
    <div id="footer-t">
        <div class="container">
            <div class="row">
                <div id="logo-f" class="col-md-3 col-sm-12 col-xs-12 text-center">
                    <a routerLink="/pkl/home"><img src="/resources/images/logo4.png"></a>
                </div>
                <div id="about" class="col-md-3 col-sm-12 col-xs-12">
                    <h3>About us</h3>
                    <p class="text-justify">Academy thành lập năm 2009.
                        Chúng tôi chuyên cung cấp các dòng xe phân khối lớn cũ và mới cho thị trường Việt Nam.
                        Với uy tín làm việc chúng tôi luôn tự tin đi đầu về giá và chất lượng của xe.</p>
                </div>
                <div id="hotline" class="col-md-3 col-sm-12 col-xs-12">
                    <h3>Hotline</h3>
                    <p>Phone Sale: (+84) 0966344241</p>
                    <p>Email: hunghn.dev@gmail.com</p>
                </div>
                <div id="contact" class="col-md-3 col-sm-12 col-xs-12">
                    <h3>Contact Us</h3>
                    <p>Address 1: Số 4 Ngõ 488/43 - Cổ Nhuế - Hà Nội</p>
                    <p>Address 2: Số 5 Ngõ 178/71 - Thạch Thất - Hà Nội</p>
                </div>
            </div>
        </div>
        <div id="footer-b">
            <div class="container">
                <div class="row">
                    <div id="footer-b-l" class="col-md-6 col-sm-12 col-xs-12 text-center">
                        <p>Hùng Đây Rồi</p>
                    </div>
                    <div id="footer-b-r" class="col-md-6 col-sm-12 col-xs-12 text-center">
                        <p>© 2009 Academy. All Rights Reserved</p>
                    </div>
                </div>
            </div>
            <div id="scroll">
                <a href="#"><img src=""></a>
            </div>
        </div>
    </div>
</footer>
<!-- endfooter -->
<script type="text/javascript">
    $(function() {
        var pull        = $('#pull');
        menu        = $('nav ul');
        menuHeight  = menu.height();

        $(pull).on('click', function(e) {
            e.preventDefault();
            menu.slideToggle();
        });
    });

    $(window).resize(function(){
        var w = $(window).width();
        if(w > 320 && menu.is(':hidden')) {
            menu.removeAttr('style');
        }
    });
</script>
</body>
</html>
