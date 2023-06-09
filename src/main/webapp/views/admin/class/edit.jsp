<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Thêm lớp học</title>
</head>
<body>
<c:set var="courseList" value="${requestScope.courseList}"/>

<h3 class="text-center">Thông tin lớp học</h3>
<br>
<form id="formClass">
    <div class="mb-3 row">
        <label for="nameClass" class="col-sm-2 col-form-label">Tên lớp học</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="nameClass" name="name" required>
            <div class="invalid-feedback">
                Vui lòng điền đúng tên lớp học. Ví dụ: A!
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label" for="courseCode">Khóa</label>
        <div class="col-sm-10">
            <input class="form-control" list="datalistOptions" id="courseCode" required placeholder="Gõ để tìm kiếm" name="courseCode">
            <div class="invalid-feedback">
                Vui lòng chọn đúng mã khóa học!
            </div>
            <datalist id="datalistOptions">
                <c:forEach var="course" items="${courseList}">
                <option value="${course.code}">
                    </c:forEach>
            </datalist>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-4">
            <button type="submit" class="btn btn-primary" id="btnSubmit" data-toggle="modal">Submit</button>
        </div>

        <div class="col-sm-4">
            <input class= "btn btn-primary" type="reset" value="Reset">
        </div>
    </div>
</form>

<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false"
     tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xác nhận thông tin lớp học</h5>
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

    function insertClass(jsonData) {
        $.ajax({
            url: "<c:url value="/api-class"/>",
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

            const nameClassInput = document.getElementById('nameClass');
            const courseCodeInput = document.getElementById('courseCode');
            const options = document.getElementById('datalistOptions').getElementsByTagName('option');

            const regex = /^[A-Za-z]$/;
            const isValidClassName = regex.test(nameClassInput.value.trim());

            let isValidCourseCode = false;
            for (let i = 0; i < options.length; i++) {
                if (courseCodeInput.value.trim().toUpperCase() === options[i].value) {
                    isValidCourseCode = true;
                    break;
                }
            }

            if (isValidClassName) {
                nameClassInput.classList.remove('is-invalid');

                if (isValidCourseCode) {
                    courseCodeInput.classList.remove('is-invalid');

                    let confirmationText = 'Thông tin:\n';
                    confirmationText += '\nTên lớp học: ' + $('#nameClass').val().toUpperCase();
                    confirmationText += '\nMã khóa học: ' + $('#courseCode').val().toUpperCase();
                    document.getElementById('confirmationText').innerText = confirmationText;
                    this.setAttribute("data-target", "#staticBackdrop");
                } else {
                    courseCodeInput.classList.add('is-invalid');

                    this.removeAttribute('data-target');
                }
            } else {
                nameClassInput.classList.add('is-invalid');

                this.removeAttribute('data-target');
            }
        });

        $("#btnSend").click(function (event) {
            event.preventDefault();
            const formData = $("#formClass").serializeArray();
            const jsonData = {};
            $.each(formData, function (index, field) {
                jsonData[field.name] = field.value.toUpperCase();
            })
            console.log(jsonData);
            insertClass(jsonData);
        });
    });
</script>
</body>
</html>
