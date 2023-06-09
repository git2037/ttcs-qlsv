<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Trung tâm thông báo</title>
</head>
<body>

<c:set value="${requestScope.notificationList}" var="notificationList"/>
<c:set value="${requestScope.studentList}" var="studentList"/>

<div style="padding-left: 50px; padding-right: 50px">
    <form action="<c:url value="/admin-notification"/>" method="post">
        <div class="col-lg-4">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Nhập mã sinh viên" name="studentCode">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
        </div>
        <br>
    </form>
    <c:if test="${not empty notificationList}">
        <c:forEach var="notification" items="${notificationList}" varStatus="status">

            <c:forEach items="${studentList}" var="student">
                <c:if test="${notification.studentID eq student.id}">
                    <c:set var="studentCode" value="${student.code}"/>
                    <c:set var="studentname" value="${student.fullname}"/>
                </c:if>
            </c:forEach>
            <div class="col-lg-12">
                <div class="card shadow mb-4">
                    <!-- Card Header-Accordion -->
                    <a href="#collapseCardExample${status.index}" class="d-block card-header py-3"
                       data-toggle="collapse"
                       role="button" aria-expanded="true" aria-controls="collapseCardExample${status.index}">
                        <c:if test="${notification.status eq 0}">
                            <h6 class="m-0 font-weight-bold text-primary" id="cardTitle">${studentname} - ${studentCode}
                                <span id="badge" class="badge badge-danger badge-counter">New</span>
                            </h6>
                        </c:if>

                        <c:if test="${notification.status eq 1}">
                            <h6 class="m-0 text-gray-800">${studentname} - ${studentCode}</h6>
                        </c:if>

                    </a>
                    <!-- Card Content - Collapse -->
                    <div class="collapse" id="collapseCardExample${status.index}">
                        <div class="card-body">
                                ${notification.content}
                            <c:if test="${notification.status eq 0}">
                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                    <button class="btn btn-primary" id="btnRead" type="button"
                                            data-id="${notification.id}"
                                            onclick="sendData(this)">
                                        Đã đọc
                                    </button>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
<script>

    function sendData(element) {
        const id = element.getAttribute('data-id');
        const jsonData = {id: id, "status": 1};

        $.ajax({
            type: 'PUT',
            url: '<c:url value="/api-notification"/>',
            data: JSON.stringify(jsonData),
            contentType: 'application/json;charset=UTF-8',
            success: function (response) {
                console.log(response);
                location.reload();
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
