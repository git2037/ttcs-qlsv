<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Gửi thông báo</title>
</head>
<body>

<c:set value="${sessionScope.studentID}" var="studentID"/>
<div class="form-container" style="padding: 50px 300px 50px;">
    <h3 class="text-center">Gửi Thông Báo</h3>

    <div class="form-floating mb-3">
        <textarea class="form-control" id="content" name="content" placeholder="Thông báo" required></textarea>
        <label for="content">Nội dung thông báo</label>
        <div class="invalid-feedback">
            Thông Báo không để trống!
        </div>
    </div>

    <div class="d-grid gap-2 col-4 mx-auto">
        <button class="btn btn-primary" type="button" id="btnSubmit">Gửi</button>
    </div>
</div>

<script>
    $("#btnSubmit").click(function (event) {
        event.preventDefault();

        var content = document.getElementById('content');

        if (content.value.trim() === '') {
            content.classList.add('is-invalid');
            return;
        } else {
            content.classList.remove('is-invalid');
        }

        const jsonData = {};
        jsonData["content"] = content.value.replace(/\n/g, "<br>");
        jsonData["studentID"] = ${studentID};
        jsonData["adminID"] = 1;
        jsonData["status"] = 0;
        console.log(jsonData);


        $.ajax({
            url: "<c:url value="/api-notification"/>",
            type: "POST",
            data: JSON.stringify(jsonData),
            contentType: "application/json",
            success: function(response) {
                alert("Gửi thành công!");
                console.log(response);
            },
            error: function(error) {
                alert("Gửi thất bại!");
                console.error(error);
            }
        })
    });
</script>

</body>
</html>
