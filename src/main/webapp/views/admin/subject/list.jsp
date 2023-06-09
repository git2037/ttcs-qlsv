<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Danh sách học phần</title>
</head>
<body>
<c:set var="subjectList" value="${requestScope.subjectList}"/>

<h1 class="h3 mb-2 text-gray-800">Danh sách</h1>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Danh sách học phần</h6>
    </div>

    <div class="card-body">
        <div class="row">
            <div class="col-sm-9">
                <div id="add" class="dataTables_filter">
                    <a href="<c:url value="/admin-subject?action=insert"/>">
                        <p class="text-center">Thêm học phần</p>
                    </a>
                </div>
            </div>
            <div class="col-sm-3 text-right">
                <div id="exportButtons" class="button-container"></div>
            </div>
        </div>
        <br>

        <div class="table-responsive">
            <table class="table table-bordered table-hover" id="tblSubject" aria-label="">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã học phần</th>
                        <th>Tên học phần</th>
                        <th>Số tín chỉ</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${subjectList}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${item.code}</td>
                            <td>${item.name}</td>
                            <td>${item.credit}</td>
                            <td>
                                <div class="dropdown no-arrow">
                                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                                        <a class="dropdown-item" href="<c:url value="/admin-subject?action=update&id=${item.id}"/>">
                                            Sửa thông tin
                                        </a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="<c:url value="/admin-score?subjectID=${item.id}"/>">
                                            Danh sách điểm
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
