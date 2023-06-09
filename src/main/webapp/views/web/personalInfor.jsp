<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Thông tin cá nhân</title>
</head>
<body>

<c:set value="${requestScope.studentModel}" var="studentModel"/>
<c:set value="${requestScope.classModel}" var="classModel"/>

<div class="form-container" style="padding: 50px 200px;">
    <h3 class="text-center">Thông Tin Cá Nhân</h3>
    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Mã sinh viên</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" value="${studentModel.code}">
        </div>
    </div>

    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Họ và tên</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" value="${studentModel.fullname}">
        </div>
    </div>

    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Giới tính</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" value="${studentModel.gender}">
        </div>
    </div>

    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Địa chỉ</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" value="${studentModel.address}">
        </div>
    </div>

    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Ngày sinh</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" value="${studentModel.dob}">
        </div>
    </div>



    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Tình trạng</label>
        <div class="col-sm-10">
            <c:if test="${studentModel.status == 1}">
                <input type="text" readonly class="form-control-plaintext" value="Đang học">
            </c:if>

            <c:if test="${studentModel.status == 0}">
                <input type="text" readonly class="form-control-plaintext" value="Đã tốt nghiệp">
            </c:if>

        </div>
    </div>

    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Lớp học</label>
        <div class="col-sm-10">
            <input type="text" readonly class="form-control-plaintext" value="${classModel.name}">
        </div>
    </div>
</div>

</body>
</html>
