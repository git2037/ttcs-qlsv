<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Thông tin</title>
</head>
<body>
<c:set var="subjectModel" value="${requestScope.subjectModel}"/>

<h3 class="text-center">Thông tin học phần</h3>
<br>
<form id="formSubject">
    <div class="mb-3 row">
        <label for="subjectCode" class="col-sm-2 col-form-label">Mã học phần</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="subjectCode" name="code" value="${subjectModel.code}" required>
            <div class="invalid-feedback">
                Vui lòng không để trống!
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label for="subjectName" class="col-sm-2 col-form-label">Tên học phần</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="subjectName" name="name" value="${subjectModel.name}" required>
            <div class="invalid-feedback">
                Vui lòng không để trống!
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label for="subjectCredit" class="col-sm-2 col-form-label">Số tín chỉ</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="subjectCredit" name="credit" value="${subjectModel.credit}" required>
            <div class="invalid-feedback">
                Vui lòng không để trống!
            </div>
        </div>
    </div>

    <input id="id" name="id" type="hidden" value="${subjectModel.id}">

    <div class="row">
        <div class="col-sm-4">
            <button type="button" class="btn btn-primary" id="btnSubmit" data-toggle="modal">
                Submit
            </button>
        </div>

        <c:if test="${empty subjectModel.id}">
            <div class="col-sm-4">
                <input class= "btn btn-primary" type="reset" value="Reset">
            </div>
        </c:if>
    </div>
</form>

<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xác nhận thông tin học phần</h5>
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

    function insertSubject(jsonData) {
        $.ajax({
            url: "<c:url value="/api-subject"/>",
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

    function updateSubject(jsonData) {
        $.ajax({
            url: "<c:url value="/api-subject"/>",
            type: "PUT",
            data: JSON.stringify(jsonData),
            contentType: "application/json",
            success: function(response) {
                alert("Sửa thành công!");
                console.log(response);
                window.location.href = window.document.referrer;
            },
            error: function(error) {
                alert("Sửa thất bại!");
                console.error(error);
            }
        })
    }

    $(document).ready(function () {

        $("#btnSubmit").click(function (event) {
            event.preventDefault();

            const subjectCodeInput = document.getElementById('subjectCode');
            const subjectNameInput = document.getElementById('subjectName');
            const subjectCreditInput = document.getElementById('subjectCredit');

            const subjectCreditRegex = /^\d{1,2}$/;

            if (subjectCodeInput.value.trim() !== '') {
                subjectCodeInput.classList.remove('is-invalid');

                if (subjectNameInput.value.trim() !== '') {
                    subjectNameInput.classList.remove('is-invalid');

                    if (subjectCreditRegex.test(subjectCreditInput.value.trim())) {
                        subjectCreditInput.classList.remove('is-invalid');

                        let confirmationText = 'Thông tin:\n';
                        confirmationText += '\nMã học phần: ' + $('#subjectCode').val();
                        confirmationText += '\nTên học phần: ' + $('#subjectName').val();
                        confirmationText += '\nSố tín chỉ: ' + $('#subjectCredit').val();
                        document.getElementById('confirmationText').innerText = confirmationText;
                        this.setAttribute("data-target", "#staticBackdrop");
                    } else {
                        subjectCreditInput.classList.add('is-invalid');
                        this.removeAttribute('data-target');
                    }
                } else {
                    subjectNameInput.classList.add('is-invalid');
                    this.removeAttribute('data-target');
                }
            } else {
                subjectCodeInput.classList.add('is-invalid');
                this.removeAttribute('data-target');
            }
        });

        $("#btnSend").click(function (event) {
            event.preventDefault();
            const id = $('#id').val();

            const formData = $("#formSubject").serializeArray();
            const jsonData = {};
            $.each(formData, function (index, field) {
                if (field.name === 'code') {
                    jsonData[field.name] = field.value.toUpperCase();
                } else {
                    jsonData[field.name] = field.value;
                }
            })
            console.log(jsonData);

            if (id === ""){
                insertSubject(jsonData);
            } else {
                updateSubject(jsonData);
            }
        });
    });
</script>
</body>
</html>
