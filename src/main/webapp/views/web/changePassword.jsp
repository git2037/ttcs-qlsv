<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Đổi mật khẩu</title>
</head>
<body>

<c:set value="${sessionScope.studentID}" var="studentID"/>
<c:set value="${requestScope.acc}" var="acc"/>
<div class="form-container" style="padding: 50px 300px 50px;">
    <h3 class="text-center">Đổi Mật Khẩu</h3>
    <form class="row g-3 needs-validation" novalidate>

        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="newPass" name="newPass" placeholder="Mật khẩu mới"
                   required>
            <label for="newPass">Mật khẩu mới</label>
            <div class="invalid-feedback">
                Mật khẩu mới không được để trống!
            </div>
        </div>

        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="repeatPass" name="repeatPass"
                   placeholder="Gõ lại mật khẩu mới" required>
            <label for="repeatPass">Gõ lại mật khẩu mới</label>
            <div class="invalid-feedback">
                Gõ lại mật khẩu không giống với mật khẩu mới!
            </div>
        </div>

        <div class="d-grid gap-2 col-4 mx-auto">
            <button class="btn btn-primary" type="submit" id="btnSubmit">Thay đổi</button>
        </div>
    </form>
</div>

<script>
    $("#btnSubmit").click(function (event) {
        event.preventDefault();
        const newPass = document.getElementById('newPass');
        const repeatPass = document.getElementById('repeatPass');

        // Kiểm tra ô mật khẩu không được để trống
        if (newPass.value.trim() === '') {
            newPass.classList.add('is-invalid');
            return;
        } else {
            newPass.classList.remove('is-invalid');
        }

        if (repeatPass.value.trim() === '' || repeatPass.value.trim() !== newPass.value.trim()) {
            repeatPass.classList.add('is-invalid');
            return;
        } else {
            repeatPass.classList.remove('is-invalid');
        }

        const jsonData = {"password" : newPass.value, "id" : ${acc.id}};
        console.log(jsonData);

        $.ajax({
            url: "<c:url value="/api-account"/>",
            type: "PUT",
            data: JSON.stringify(jsonData),
            contentType: "application/json",
            success: function(response) {
                alert("Sửa thành công!");
                console.log(response);
            },
            error: function(error) {
                alert("Sửa thất bại!");
                console.error(error);
            }
        })
    });
</script>

</body>
</html>
