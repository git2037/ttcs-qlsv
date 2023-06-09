<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Trang chủ</title>

    <link href="<c:url value="/template/web/assets/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/web/assets/vendor/bootstrap-icons/bootstrap-icons.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/web/assets/css/style.css"/>" rel="stylesheet">
</head>
<body>

<%--<!-- ======= Header ======= -->--%>
<header id="header" class="fixed-top header-transparent">
    <div class="container d-flex align-items-center justify-content-between">

        <h1 class="logo"></h1>
        <nav id="navbar" class="navbar">
            <ul>
                <a class="nav-link scrollto active" href="<c:url value="/dang-nhap?action=login"/>">Đăng nhập</a>

            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->

    </div>
</header><!-- End Header -->

<!-- ======= Hero Section ======= -->
<section id="hero" class="d-flex align-items-center justify-content-center">
    <div class="container position-relative">
        <h1>Website quản lý điểm cho sinh viên</h1>
    </div>
</section><!-- End Hero -->

<main id="main">

    <!-- ======= About Section ======= -->
    <section id="about" class="about">
        <div class="container">

            <div class="row">
                <div class="col-lg-6">
                    <img src="<c:url value="/template/web/assets/img/overview.jpg" />" class="img-fluid" alt="">
                </div>
                <div class="col-lg-6 pt-4 pt-lg-0">
                    <h3>Quản lý thông tin</h3>
                    <p>
                        - Website giúp quản trị viên quản lý các thông tin của sinh viên. Có thể thêm, sửa, xóa thông tin
                        nếu cần thiết
                    </p>

                    <p>
                        - Giao diện trực quan dễ sử dụng
                    </p>

                </div>
            </div><br><br>

            <div class="row">
                <div class="col-lg-6">
                    <img src="<c:url value="/template/web/assets/img/search-infor.jpeg"/>" class="img-fluid" alt="">
                </div>
                <div class="col-lg-6 pt-4 pt-lg-0">
                    <h3>Tra cứu thông tin</h3>
                    <p>
                        - Website giúp sinh viên dễ dàng xem điểm thi của mình cũng như thông tin cá nhân.
                        Điều này giúp theo dõi tiến trình học tập và đánh giá hiệu quả học tập của sinh viên.
                    </p>

                    <p>
                        - Sinh viên có thể thông báo cho quản trị viên về những thông tin bị sai, bị thiếu.
                    </p>

                </div>
            </div>

        </div>
    </section><!-- End About Section -->
</main>


<a href="#" class="back-to-top d-flex align-items-center justify-content-center">
    <i class="bi bi-arrow-up-short"></i></a>

<!-- Template Main JS File -->
<script src="<c:url value="/template/web/assets/js/main.js"/>"></script>

</body>

</html>