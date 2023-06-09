<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set value="${sessionScope.fullName}" var="fullName"/>
<header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center justify-content-between">

        <h1 class="logo">
        </h1>
        <nav id="navbar" class="navbar">
            <ul>
                <c:if test="${empty fullName}">
                    <li><a class="nav-link scrollto " href="<c:url value="/dang-nhap?action=login"/>">Đăng nhập</a></li>
                </c:if>

                <c:if test="${not empty fullName}">
                    <li><a class="nav-link scrollto " href="<c:url value="/ds-diem"/>">Thông tin điểm</a></li>
                    <li><a class="nav-link scrollto " href="<c:url value="/thong-bao"/>">Gửi thông báo</a></li>
                    <li class="dropdown"><a href="#"><span>Xin chào, ${fullName}</span><i class="bi bi-chevron-down"></i></a>
                        <ul>
                            <li><a href="<c:url value="/thong-tin-ca-nhan"/>">Thông tin cá nhân</a></li>
                            <li><a href="<c:url value="/thay-mat-khau"/>">Thay mật khẩu</a></li>
                            <li><a href="<c:url value="/dang-xuat?action=logout"/>">Đăng xuất</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->

    </div>
</header><!-- End Header -->