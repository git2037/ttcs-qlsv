<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Danh sách khóa học</title>
</head>
<body>
<c:set var="courseList" value="${requestScope.courseList}"/>

<h1 class="h3 mb-2 text-gray-800">Danh sách</h1>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Danh sách khóa học</h6>
    </div>

    <div class="card-body">
        <div class="row">
            <div class="col-sm-9">
                <div id="add" class="dataTables_filter">
                    <a href="<c:url value="/admin-course?action=insert"/>">
                        <p class="text-center">Thêm khóa học</p>
                    </a>
                </div>
            </div>
            <div class="col-sm-3 text-right">
                <div id="exportButtons" class="button-container"></div>
            </div>
        </div>
        <br>

        <div class="table-responsive">
            <table class="table table-bordered table-hover" id="tblCourse" aria-label="">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã khóa học</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${courseList}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${item.code}</td>
                            <td>
                                <div class="dropdown no-arrow">
                                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                                        <a class="dropdown-item" href="<c:url value="/admin-class?id=${item.id}"/>">
                                            Danh sách lớp học
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
</body>
</html>
