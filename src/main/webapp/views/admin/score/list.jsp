<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Danh sách điểm</title>
</head>
<body>
<c:set var="studentList" value="${requestScope.studentList}"/>
<c:set var="subjectList" value="${requestScope.subjectList}"/>
<c:set var="scoreList" value="${requestScope.scoreList}"/>


<h1 class="h3 mb-2 text-gray-800">Danh sách</h1>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Danh sách điểm</h6>
    </div>

    <div class="card-body">
        <div class="row">
            <div class="col-sm-9">
                <div id="add" class="dataTables_filter">
                    <a href="<c:url value="/admin-score?action=insert"/>">
                        <p class="text-center">Thêm điểm</p>
                    </a>
                </div>
            </div>
            <div class="col-sm-3 text-right">
                <div id="exportButtons" class="button-container"></div>
            </div>
        </div>
        <br>

        <div class="table-responsive">
            <table class="table table-bordered table-hover" id="tblScore" aria-label="">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã sinh viên</th>
                        <th>Mã học phần</th>
                        <th>Điểm giữa kỳ</th>
                        <th>Điểm chuyên cần</th>
                        <th>Điểm cuối kỳ</th>
                        <th>Điểm tổng kết</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="score" items="${scoreList}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <c:forEach items="${studentList}" var="student">
                                <c:if test="${score.studentID eq student.id}">
                                    <c:set var="studentCode" value="${student.code}"/>
                                </c:if>
                            </c:forEach>
                            <td>${studentCode}</td>

                            <c:forEach items="${subjectList}" var="subject">
                                <c:if test="${score.subjectID eq subject.id}">
                                    <c:set var="subjectCode" value="${subject.code}"/>
                                </c:if>
                            </c:forEach>
                            <td>${subjectCode}</td>

                            <td>${score.score1}</td>
                            <td>${score.score2}</td>
                            <td>${score.score3}</td>
                            <td>${score.totalScore}</td>

                            <td>
                                <div class="dropdown no-arrow">
                                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">

                                        <a class="dropdown-item" href="<c:url value="/admin-score?action=update&id=${score.id}"/>">
                                            Sửa thông tin
                                        </a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" data-id="${score.id}" href="#" onclick="remove(this)">
                                            Xóa
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

    function remove(element) {
        const id = element.getAttribute('data-id');
        const jsonData = { id: id};

        $.ajax({
            type: 'DELETE',
            url: '<c:url value="/api-score"/>',
            data: JSON.stringify(jsonData),
            contentType: 'application/json;charset=UTF-8',
            success: function(response) {
                alert("Xóa thành công!");
                console.log(response);
                location.reload();
            },
            error: function(xhr, status, error) {
                alert("Xóa thất bại!");
                console.error(error);
            }
        });
    }

</script>
</body>
</html>
