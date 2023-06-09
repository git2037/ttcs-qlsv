<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title><dec:title default="Trang chủ"/></title>

    <link href="<c:url value="/template/web/assets/css/font.css"/>" rel="stylesheet">

    <link href="<c:url value="/template/web/assets/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/web/assets/vendor/bootstrap-icons/bootstrap-icons.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/web/assets/css/style.css"/>" rel="stylesheet">

    <script src="<c:url value="/template/web/assets/js/cdn.datatables.net_v_bs5_jq-3.6.0_jszip-2.5.0_dt-1.13.4_b-2.3.6_b-html5-2.3.6_datatables.min.js"/>"></script>
    <link href="<c:url value="/template/web/assets/css/cdnjs.cloudflare.com_ajax_libs_twitter-bootstrap_5.1.3_css_bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/web/assets/css/cdn.datatables.net_v_bs5_jq-3.6.0_jszip-2.5.0_dt-1.13.4_b-2.3.6_b-html5-2.3.6_datatables.min.css"/>" rel="stylesheet">

</head>

<body>

<%@include file="/common/web/header.jsp" %>
<br><br>

<main id="main">

    <section class="inner-page">
        <div class="container">
            <dec:body/>
        </div>
    </section>

</main>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center">
    <i class="bi bi-arrow-up-short"></i>
</a>

<script src="<c:url value="/template/web/assets/js/main.js"/>"></script>

</body>

</html>
