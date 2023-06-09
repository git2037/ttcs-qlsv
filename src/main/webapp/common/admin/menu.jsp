<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value="/admin-home"/>">
        <div class="sidebar-brand-icon">
            <i class="fas fa-home fa-lg"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Trang chủ</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">
    <hr class="sidebar-divider">

    <!-- Nav Item - Tables -->
    <div class="sidebar-heading">
        Danh sách
    </div>

    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin-course"/>">
            <i class="fas fa-fw fa-table"></i>
            <span>Danh sách khóa học</span></a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin-class"/>">
            <i class="fas fa-fw fa-table"></i>
            <span>Danh sách lớp học</span></a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin-student"/>">
            <i class="fas fa-fw fa-table"></i>
            <span>Danh sách sinh viên</span></a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin-subject"/>">
            <i class="fas fa-fw fa-table"></i>
            <span>Danh sách học phần</span></a>
    </li>

    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin-score"/>">
            <i class="fas fa-fw fa-table"></i>
            <span>Danh sách điểm</span></a>
    </li>



    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>
<!-- End of Sidebar -->