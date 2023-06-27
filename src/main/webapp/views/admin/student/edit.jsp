<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Thông tin</title>
</head>
<body>
<c:set var="studentModel" value="${requestScope.studentModel}"/>
<c:set var="classList" value="${requestScope.classList}"/>
<c:set var="action" value="${param.action}"/>

<h3 class="text-center">Thông tin sinh viên</h3>
<br>

<form id="formStudent">
    <c:if test="${not empty studentModel.code}">
        <div class="mb-3 row">
            <label for="codeStudent" class="col-sm-2 col-form-label">Mã sinh viên</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="codeStudent" name="code"
                       value="${studentModel.code}">
            </div>
        </div>
    </c:if>

    <c:if test="${empty studentModel.code}">
        <div class="mb-3 row">
            <label for="stt" class="col-sm-2 col-form-label">STT trong lớp</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="stt" name="code" required>
                <div class="invalid-feedback">
                    Vui lòng điền đúng STT trong lớp. Ví dụ: 1!
                </div>
            </div>
        </div>
    </c:if>

    <div class="mb-3 row">
        <label for="fullname" class="col-sm-2 col-form-label">Họ và tên</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="fullname" name="fullname" value="${studentModel.fullname}" required>
            <div class="invalid-feedback">
                Vui lòng không để trống!
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">Giới tính</label>
        <c:choose>
            <c:when test="${studentModel.gender eq 'Nữ'}">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="Nam">
                    <label class="form-check-label" for="inlineRadio1"> Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" checked name="gender" id="inlineRadio2" value="Nữ">
                    <label class="form-check-label" for="inlineRadio2"> Nữ</label>
                </div>
            </c:when>

            <c:otherwise>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" checked name="gender" id="inlineRadio3" value="Nam">
                    <label class="form-check-label" for="inlineRadio3"> Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="inlineRadio4" value="Nữ">
                    <label class="form-check-label" for="inlineRadio4"> Nữ</label>
                </div>
            </c:otherwise>
        </c:choose>

    </div>

    <div class="mb-3 row">
        <label for="address" class="col-sm-2 col-form-label">Địa chỉ</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="address" name="address" value="${studentModel.address}" required>
            <div class="invalid-feedback">
                Vui lòng không để trống!
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label for="dob" class="col-sm-2 col-form-label">Ngày sinh</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" placeholder="yyyy-mm-dd" id="dob" name="dob" value="${studentModel.dob}" required>
            <div class="invalid-feedback">
                Vui lòng điền đúng ngày sinh. Ví dụ: 2000-01-01!
            </div>
        </div>
    </div>

    <c:if test="${not empty studentModel.id}">
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Trạng thái</label>

            <c:choose>
                <c:when test="${studentModel.status eq 0}">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="status" id="inlineRadio5" value="1">
                        <label class="form-check-label" for="inlineRadio5"> Đang học</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" checked name="status" id="inlineRadio6" value="0">
                        <label class="form-check-label" for="inlineRadio6"> Đã tốt nghiệp</label>
                    </div>
                </c:when>

                <c:otherwise>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" checked name="status" id="inlineRadio7" value="1">
                        <label class="form-check-label" for="inlineRadio7"> Đang học</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="status" id="inlineRadio8" value="0">
                        <label class="form-check-label" for="inlineRadio8"> Đã tốt nghiệp</label>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </c:if>

    <c:forEach var="item" items="${classList}">
        <c:if test="${studentModel.classID eq item.id}">
            <c:set var="className" value="${item.name}"/>
        </c:if>
    </c:forEach>

    <c:if test="${not empty studentModel.id}">
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Lớp học</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" name="className"
                       value="${className}">
            </div>
        </div>
    </c:if>

    <c:if test="${empty studentModel.id}">
        <div class="mb-3 row">

            <label class="col-sm-2 col-form-label" for="className">Lớp học</label>
            <div class="col-sm-10">
                <input class="form-control" list="datalistOptions1" id="className" placeholder="Gõ để tìm kiếm"
                       name="className" required>
                <div class="invalid-feedback">
                    Vui lòng chọn đúng tên lớp học!
                </div>
                <datalist id="datalistOptions1">
                    <c:forEach var="item" items="${classList}">
                    <option value="${item.name}">
                        </c:forEach>
                </datalist>
            </div>
        </div>
    </c:if>

    <input type="hidden" name="id" id="id" value="${studentModel.id}">

    <div class="row">
        <div class="col-sm-4">
            <button type="button" class="btn btn-primary" id="btnSubmit" data-toggle="modal">Submit</button>
        </div>

        <div class="col-sm-4">
            <c:if test="${empty studentModel.id}">
                <c:if test="${action eq 'insert'}">
                    <input class= "btn btn-primary" type="reset" value="Reset">
                </c:if>
            </c:if>
        </div>
    </div>
</form>

<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xác nhận thông tin sinh viên</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>

            <div class="modal-body">
                <p id="confirmationText"></p>
            </div>

            <div class="modal-footer">
                <button class="btn btn-primary" type="button" id="btnSend" data-dismiss="modal">Xác nhận</button>
            </div>
        </div>
    </div>
</div>

<script>

    function insertStudent(jsonData) {
        $.ajax({
            url: "<c:url value="/api-student"/>",
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

    function updateStudent(jsonData) {
        $.ajax({
            url: "<c:url value="/api-student"/>",
            type: "PUT",
            data: JSON.stringify(jsonData),
            contentType: "application/json",
            success: function(response) {
                alert("Update thành công!");
                console.log(response);
                window.location.href = window.document.referrer;
            },
            error: function(error) {
                alert("Update thất bại!");
                console.error(error);
            }
        })
    }

    $(document).ready(function () {
        $("#btnSubmit").click(function (event) {
            event.preventDefault();

            const id = $("#id").val();

            const fullnameInput = document.getElementById('fullname');
            const addressInput = document.getElementById('address');
            const dobInput = document.getElementById('dob');
            const classNameInput = document.getElementById('className');
            let options;
            const indexRegex = /^\d{1,2}$/;
            const dobRegex = /^\d{4}-\d{2}-\d{2}$/;

            let check = false;
            let indexInput;
            let isValidClassName = false;
            if (id === ''){
                indexInput = document.getElementById('stt');
                check = indexRegex.test(indexInput.value.trim());
                options = document.getElementById('datalistOptions1').getElementsByTagName('option');
                for (let i = 0; i < options.length; i++) { // check value className input format
                    if (classNameInput.value.trim().toUpperCase() === options[i].value) {
                        isValidClassName = true;
                        break;
                    }
                }
            } else {
                check = true;
                isValidClassName = true;
            }

            if (check) { // input stt format correct
                if (id === ''){
                    indexInput.classList.remove('is-invalid');
                }
                if (fullnameInput.value.trim() !== '') { // input fullname format correct
                    fullnameInput.classList.remove('is-invalid');

                    if (addressInput.value.trim() !== '') { // input address format correct
                        addressInput.classList.remove('is-invalid');

                        if (dobRegex.test(dobInput.value.trim())) { // input dob format correct
                            dobInput.classList.remove('is-invalid');

                            if (isValidClassName) { // input className format correct

                                const id = $("#id").val();
                                const gender = $('input[name="gender"]:checked').val();
                                const status = $('input[name="status"]:checked').val();

                                let confirmationText = 'Thông tin:\n';
                                if (id === ""){
                                    confirmationText += '\nSTT: ' + $('#stt').val();
                                }
                                confirmationText += '\nHọ và tên: ' + $('#fullname').val();
                                confirmationText += '\nGiới tính: ' + gender;
                                confirmationText += '\nĐịa chỉ: ' + $('#address').val();
                                confirmationText += '\nNgày sinh: ' + $('#dob').val();
                                if (id !== ""){
                                    if (status === '1') {
                                        confirmationText += '\nTình trạng: Đang học';
                                    } else if (status === '0') {
                                        confirmationText += '\nTình trạng: Đã tốt nghiệp';
                                    }
                                } else {
                                    classNameInput.classList.remove('is-invalid');
                                    confirmationText += '\nLớp học: ' + $('#className').val();
                                }
                                document.getElementById('confirmationText').innerText = confirmationText;
                                this.setAttribute("data-target", "#staticBackdrop");
                            } else { // input className format incorrect
                                classNameInput.classList.add('is-invalid');
                                this.removeAttribute('data-target');
                            }
                        } else { // // input dob format incorrect
                            dobInput.classList.add('is-invalid');
                            this.removeAttribute('data-target');
                        }
                    } else { // input address format incorrect
                        addressInput.classList.add('is-invalid');
                        this.removeAttribute('data-target');
                    }
                } else {  // input fullname format incorrect
                    fullnameInput.classList.add('is-invalid');
                    this.removeAttribute('data-target');
                }
            } else { // input stt format incorrect
                indexInput.classList.add('is-invalid');
                this.removeAttribute('data-target');
            }
        });

        $("#btnSend").click(function (event) {
            event.preventDefault();
            const formData = $("#formStudent").serializeArray();
            const jsonData = {};
            $.each(formData, function (index, field) {
                jsonData[field.name] = field.value;
            })
            console.log(jsonData);

            const id = $("#id").val();
            if (id === ""){
                insertStudent(jsonData);
            } else {
                updateStudent(jsonData);
            }
        });
    });
</script>
</body>
</html>