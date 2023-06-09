<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>
<c:set var="studentList" value="${requestScope.studentList}"/>
<c:set var="classList" value="${requestScope.classList}"/>
<c:set var="type" value="${param.type}"/>


<h1 class="h3 mb-2 text-gray-800">Danh sách</h1>
<br>
<c:if test="${empty type}">
    <div class="row">
        <div class="col-sm-5">
            <a class="btn btn-primary" role="button"
               href="<c:url value="/admin-student?type=current"/>">DS sinh viên đang học</a>
        </div>

        <div class="col-sm-5">
            <a class="btn btn-primary" role="button"
               href="<c:url value="/admin-student?type=graduated"/>">DS sinh viên đã tốt nghiệp</a>
        </div>
    </div>
</c:if>

<%--</nav>--%>
<br><br>

<div class="card shadow mb-4">
    <div class="card-header py-3">

        <c:choose>
            <c:when test="${not empty type}">
                <c:if test="${type eq 'curr'}">
                    <h6 class="m-0 font-weight-bold text-primary">Danh sách sinh viên đang học</h6>
                </c:if>

                <c:if test="${type eq 'graduated'}">
                    <h6 class="m-0 font-weight-bold text-primary">Danh sách sinh viên đã tốt nghiệp</h6>
                </c:if>
            </c:when>
            <c:otherwise>
                <h6 class="m-0 font-weight-bold text-primary">Danh sách sinh viên</h6>
            </c:otherwise>
        </c:choose>

    </div>

    <div class="card-body">
        <div class="row">
            <div class="col-sm-9">
                <div id="add" class="dataTables_filter">
                    <c:choose>
                        <c:when test="${type eq 'graduated'}">
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value="/admin-student?action=insert"/>">
                                <p class="text-center">Thêm sinh viên</p>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="col-sm-3 text-right">
                <div id="exportButtons" class="button-container"></div>
            </div>
        </div>
        <br>

        <div class="table-responsive">
            <table class="table table-bordered table-hover" id="tblStudent" aria-label="">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã sinh viên</th>
                    <th>Họ và tên</th>
                    <th>Giới tính</th>
                    <th>Địa chỉ</th>
                    <th>Ngày sinh</th>
                    <th>Lớp học</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${studentList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${student.code}</td>
                        <td>${student.fullname}</td>
                        <td>${student.gender}</td>
                        <td>${student.address}</td>
                        <td>${student.dob}</td>

                        <c:forEach var="item" items="${classList}">
                            <c:if test="${item.id eq student.classID}">
                                <c:set var="className" value="${item.name}"/>
                            </c:if>
                        </c:forEach>
                        <td>${className}</td>
                        <td>
                            <div class="dropdown no-arrow">
                                <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                     aria-labelledby="dropdownMenuLink">
                                    <a class="dropdown-item" data-id="${student.accountID}" href="#"
                                       onclick="resetPassword(this)">
                                        Reset password
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item"
                                       href="<c:url value="/admin-student?action=update&id=${student.id}"/>">
                                        Sửa thông tin
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item"
                                       href="<c:url value="/admin-score?&studentID=${student.id}"/>">
                                        Điểm
                                    </a>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>

    function resetPassword(element) {
        const id = element.getAttribute('data-id');
        const jsonData = {id: id, "password": "123456"};

        $.ajax({
            type: 'PUT',
            url: '<c:url value="/api-account"/>',
            data: JSON.stringify(jsonData),
            contentType: 'application/json;charset=UTF-8',
            success: function (response) {
                alert("Reset thành công!");
                console.log(response);
            },
            error: function (xhr, status, error) {
                alert("Reset thất bại!");
                console.error(error);
            }
        });
    }

</script>
</body>
</html>
