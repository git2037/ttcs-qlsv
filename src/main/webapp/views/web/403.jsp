<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>403 Forbidden</title>
</head>
<body>

<h1>403 Forbidden</h1>
<p>Truy cập vào tài nguyên này bị cấm</p>

<c:if test="${sessionScope.role eq 'admin'}">
    <a href="<c:url value="/admin-home"/>">Quay lại trang chủ</a>
</c:if>

<c:if test="${sessionScope.role eq 'student'}">
    <a href="<c:url value="/trang-chu"/>">Quay lại trang chủ</a>
</c:if>

</body>
</html>
