<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.jpg">
    <link href="<c:url value='/resources/admin/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/admin/css/datepicker3.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/admin/css/styles.css' />" rel="stylesheet">
    <script src="<c:url value='/resources/admin/js/lumino.glyphs.js'/>" ></script>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Hùng Đây Rồi</a>
            <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user">
                        <use xlink:href="#stroked-male-user"></use></svg>
                        <security:authorize access="isAuthenticated()">
                            <security:authentication property="principal.username"/>
                        </security:authorize>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/logout"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- /.container-fluid -->
</nav>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <li role="presentation" class="divider"></li>
        <li class="active"><a href="/admin/home"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Trang Chủ</a></li>
        <li><a href="/admin/banner"><svg class="glyph stroked camera"><use xlink:href="#stroked-camera"></use></svg> Banner</a></li>
        <li><a href="/admin/category"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Category</a></li>
        <li><a href="/admin/product-list"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Product</a></li>
        <li><a href="/admin/user-list"><svg class="glyph stroked male user"><use xlink:href="#stroked-male-user"></use></svg> User</a></li>
        <li><a href="/admin/order-list"><svg class="glyph stroked clipboard with paper"><use xlink:href="#stroked-clipboard-with-paper"></use></svg> Order</a></li>
        <li role="presentation" class="divider"></li>
    </ul>
</div><!--/.sidebar-->
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

    <dec:body/>

</div>
<script src="<c:url value='/resources/admin/js/jquery-1.11.1.min.js' />" ></script>
<script src="<c:url value='/resources/admin/js/bootstrap.min.js' />" ></script>
<script src="<c:url value='/resources/admin/js/easypiechart.js'/>"></script>
<script src="<c:url value='/resources/admin/js/easypiechart-data.js'/>"></script>
<script src="<c:url value='/resources/admin/js/bootstrap-datepicker.js'/>" ></script>

<script>
    $('#calendar').datepicker({
    });
    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    });
    function changeImg(input){
        //Nếu như tồn thuộc tính file, đồng nghĩa người dùng đã chọn file mới
        if(input.files && input.files[0]){
            var reader = new FileReader();
            //Sự kiện file đã được load vào website
            reader.onload = function(e){
                //Thay đổi đường dẫn ảnh
                $('#avatar').attr('src',e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    $(document).ready(function() {
        $('#avatar').click(function(){
            $('#img').click();
        });
    });
    $(document).ready(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>

</body>
</html>
