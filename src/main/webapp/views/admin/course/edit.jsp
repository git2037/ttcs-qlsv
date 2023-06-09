<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Thêm khóa học</title>
</head>
<body>

<h3 class="text-center">Thông tin khóa học</h3>
<br>
<form id="formCourse">
    <div class="mb-3 row">
        <label for="codeCourse" class="col-sm-2 col-form-label">Mã khóa học</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="codeCourse" name="code" required>
            <div class="invalid-feedback">
                Vui lòng điền đúng mã khóa học. Ví dụ: AT01!
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-4">
            <button type="submit" class="btn btn-primary" id="btnSubmit" data-toggle="modal">
                Submit
            </button>
        </div>

        <div class="col-sm-4">
            <input class= "btn btn-primary" type="reset" value="Reset">
        </div>
    </div>
</form>

<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xác nhận thông tin khóa học</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>

            <div class="modal-body">
                <p id="confirmationText"></p>
            </div>

            <div class="modal-footer">
                <button class="btn btn-primary" type="button" data-dismiss="modal" id="btnSend">Xác nhận</button>
            </div>
        </div>
    </div>
</div>

<script>

    function insertCourse(jsonData) {
        $.ajax({
            url: "<c:url value="/api-course"/>",
            type: "POST",
            data: JSON.stringify(jsonData),
            contentType: "application/json",
            success: function(response) {
                alert("Thêm thành công!");
                console.log(response);
            },
            error: function(error) {
                alert("Thêm thất bại!");
                console.error(error);
            }
        })
    }

    $(document).ready(function () {


        $("#btnSubmit").click(function (event) {
            event.preventDefault();

            const codeCourseInput = document.getElementById('codeCourse');
            const regex = /^[A-Za-z]{2}\d{2}$/;
            const isValid = regex.test(codeCourseInput.value.trim());

            if (!isValid) {
                codeCourseInput.classList.add('is-invalid');
                this.removeAttribute('data-target');
            } else {
                codeCourseInput.classList.remove('is-invalid');
                let confirmationText = 'Thông tin:\n';
                confirmationText += '\nMã khóa học: ' + $('#codeCourse').val().trim();
                document.getElementById('confirmationText').innerText = confirmationText;
                this.setAttribute("data-target", "#staticBackdrop");
            }
        });

        $("#btnSend").click(function (event) {
            event.preventDefault();
            const code = $('#codeCourse').val().trim().toUpperCase();
            const jsonData = {code : code};
            console.log(jsonData);

            insertCourse(jsonData);
        });
    });
</script>
</body>
</html>
