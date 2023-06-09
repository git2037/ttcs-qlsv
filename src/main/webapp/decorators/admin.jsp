<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        .button-container .btn {
            margin-right: 20px;
        }
    </style>
    <title><dec:title default="Trang chủ"/></title>

    <link href="<c:url value="/template/admin/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/template/admin/css/font-google-api.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/admin/css/sb-admin-2.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/admin/vendor/datatables/dataTables.bootstrap4.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/admin/css/datatables.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/template/admin/css/select.dataTables.min.css"/>" rel="stylesheet"/>

    <script src="<c:url value="/template/admin/js/jquery-3.6.0.min.js"/>"></script>
</head>

<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <%@include file="/common/admin/menu.jsp"%>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@include file="/common/admin/header.jsp"%>
                <div class="container-fluid">
                    <dec:body />
                </div>
            </div>
        </div>
    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <script src="<c:url value="/template/admin/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
    <script src="<c:url value="/template/admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
    <script src="<c:url value="/template/admin/vendor/datatables/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="/template/admin/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

    <script src="<c:url value="/template/admin/js/demo/datatables-demo.js"/>"></script>
    <script src="<c:url value="/template/admin/js/sb-admin-2.min.js" /> "></script>
    <script src="<c:url value="/template/admin/js/pdfmake.min.js" /> "></script>
    <script src="<c:url value="/template/admin/js/vfs_fonts.js" /> "></script>
    <script src="<c:url value="/template/admin/js/datatables.min.js" /> "></script>
    <script src="<c:url value="/template/admin/js/dataTables.select.min.js" /> "></script>
</body>
</html>
