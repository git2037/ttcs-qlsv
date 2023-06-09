<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Thông tin</title>
</head>
<body>
<c:set var="studentList" value="${requestScope.studentList}"/>
<c:set var="subjectList" value="${requestScope.subjectList}"/>
<c:set var="scoreModel" value="${requestScope.scoreModel}"/>
<c:set var="action" value="${param.action}"/>

<h3 class="text-center">Thông tin điểm</h3>
<br>
<form id="formScore">
    <input type="hidden" name="id" id="id" value="${scoreModel.id}">

    <div class="mb-3 row">
        <c:forEach var="item" items="${studentList}">
            <c:if test="${scoreModel.studentID eq item.id}">
                <c:set var="studentCode" value="${item.code}"/>
            </c:if>
        </c:forEach>

        <label class="col-sm-2 col-form-label" for="studentCode">Mã sinh viên</label>
        <div class="col-sm-10">
            <input class="form-control" list="datalistOptions" id="studentCode" value="${studentCode}" placeholder="Gõ để tìm kiếm"
                   name="studentCode" required>
            <div class="invalid-feedback">
                Vui lòng chọn đúng mã sinh viên!
            </div>
            <datalist id="datalistOptions">
                <c:forEach var="item" items="${studentList}">
                    <option value="${item.code}">
                </c:forEach>
            </datalist>
        </div>
    </div>

    <div class="mb-3 row">
        <c:forEach var="item" items="${subjectList}">
            <c:if test="${scoreModel.subjectID eq item.id}">
                <c:set var="subjectCode" value="${item.code}"/>
            </c:if>
        </c:forEach>

        <label class="col-sm-2 col-form-label" for="subjectCode">Mã học phần</label>
        <div class="col-sm-10">
            <input class="form-control" list="datalistOptions1" id="subjectCode" value="${subjectCode}"
                   placeholder="Gõ để tìm kiếm" name="subjectCode" required>
            <div class="invalid-feedback">
                Vui lòng chọn đúng mã học phần!
            </div>
            <datalist id="datalistOptions1">
                <c:forEach var="item" items="${subjectList}">
                <option value="${item.code}">
                    </c:forEach>
            </datalist>
        </div>
    </div>

    <div class="mb-3 row">
        <label for="score1" class="col-sm-2 col-form-label">Điểm giữa kỳ</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="score1" name="score1" value="${scoreModel.score1}" required>
            <div class="invalid-feedback">
                Vui lòng điền đúng điểm giữa kỳ. Ví dụ: 8 hoặc 8.5!
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label for="score2" class="col-sm-2 col-form-label">Điểm chuyên cần</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="score2" name="score2" value="${scoreModel.score2}" required>
            <div class="invalid-feedback">
                Vui lòng chọn đúng điểm chuyên cần. Ví dụ: 8 hoặc 8.5!
            </div>
        </div>
    </div>

    <div class="mb-3 row">
        <label for="score3" class="col-sm-2 col-form-label">Điểm cuối kỳ</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="score3" name="score3" value="${scoreModel.score3}" required>
            <div class="invalid-feedback">
                Vui lòng điền đúng điểm cuối kỳ. Ví dụ: 8 hoặc 8.5!
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-4">
            <button type="button" class="btn btn-primary" id="btnSubmit" data-toggle="modal">
                Submit
            </button>
        </div>

        <div class="col-sm-4">
            <c:if test="${empty scoreModel.id}">
                <c:if test="${action eq 'insert'}">
                    <input class= "btn btn-primary" type="reset" value="Reset">
                </c:if>
            </c:if>
        </div>

    </div>
</form>

<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xác nhận thông tin</h5>
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

    function insertScore(jsonData) {
        $.ajax({
            url: "<c:url value="/api-score"/>",
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

    function updateScore(jsonData) {
        $.ajax({
            url: "<c:url value="/api-score"/>",
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

            const studentCodeInput = document.getElementById('studentCode');
            const options = document.getElementById('datalistOptions').getElementsByTagName('option');
            const subjectCodeInput = document.getElementById('subjectCode');
            const options1 = document.getElementById('datalistOptions1').getElementsByTagName('option');

            const score1Input = document.getElementById('score1');
            const score2Input = document.getElementById('score2');
            const score3Input = document.getElementById('score3');
            const regex = /^([0-9]|10)(\.[0-9])?$/;

            let isValidStudentCode = false;
            for (let i = 0; i < options.length; i++) {
                if (studentCodeInput.value.trim().toUpperCase() === options[i].value) {
                    isValidStudentCode = true;
                    break;
                }
            }
            let isValidSubjectCode = false;
            for (let i = 0; i < options1.length; i++) {
                if (subjectCodeInput.value.trim().toUpperCase() === options1[i].value) {
                    isValidSubjectCode = true;
                    break;
                }
            }

            if (isValidStudentCode) {
                studentCodeInput.classList.remove('is-invalid');

                if (isValidSubjectCode) {
                    subjectCodeInput.classList.remove('is-invalid');

                    if (regex.test(score1Input.value.trim())) {
                        score1Input.classList.remove('is-invalid');

                        if (regex.test(score2Input.value.trim())) {
                            score2Input.classList.remove('is-invalid');

                            if (regex.test(score3Input.value.trim())) {
                                score3Input.classList.remove('is-invalid');

                                let confirmationText = 'Thông tin:\n';
                                confirmationText += '\nMã sinh viên: ' + $('#studentCode').val();
                                confirmationText += '\nMã học phần: ' + $('#subjectCode').val();
                                confirmationText += '\nĐiểm giữa kỳ: ' + $('#score1').val();
                                confirmationText += '\nĐiểm chuyên cần: ' + $('#score2').val();
                                confirmationText += '\nĐiểm cuối kỳ: ' + $('#score3').val();

                                document.getElementById('confirmationText').innerText = confirmationText;
                                this.setAttribute("data-target", "#staticBackdrop");
                            } else {
                                score3Input.classList.add('is-invalid');
                                this.removeAttribute('data-target');
                            }
                        } else {
                            score2Input.classList.add('is-invalid');
                            this.removeAttribute('data-target');
                        }
                    } else {
                        score1Input.classList.add('is-invalid');
                        this.removeAttribute('data-target');
                    }
                } else {
                    subjectCodeInput.classList.add('is-invalid');
                    this.removeAttribute('data-target');
                }
            } else {
                studentCodeInput.classList.add('is-invalid');
                this.removeAttribute('data-target');
            }
        });

        $("#btnSend").click(function (event) {
            event.preventDefault();
            const formData = $("#formScore").serializeArray();
            const jsonData = {};
            $.each(formData, function (index, field) {
                jsonData[field.name] = field.value;
            })
            console.log(jsonData);

            const id = $("#id").val();
            if (id === ""){
                insertScore(jsonData);
            } else {
                updateScore(jsonData);
            }
        });
    });
</script>
</body>
</html>