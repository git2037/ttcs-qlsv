<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Điểm</title>
</head>
<body>

<c:set var="subjectList" value="${requestScope.subjectList}"/>
<c:set var="scoreList" value="${requestScope.scoreList}"/>
<c:set var="gpa" value="${requestScope.gpa}"/>

<div class="form-container" style="padding: 50px 0px 0px 0px;">
    <h3 class="text-center">Danh Sách Điểm</h3>
    <table class="table table-bordered table-hover" id="tblScore" aria-label="">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên học phần</th>
            <th>Điểm giữa kỳ</th>
            <th>Điểm chuyên cần</th>
            <th>Điểm cuối kỳ</th>
            <th>Điểm tổng kết</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="score" items="${scoreList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>

                <c:forEach items="${subjectList}" var="subject">
                    <c:if test="${score.subjectID eq subject.id}">
                        <c:set var="subjectName" value="${subject.name}"/>
                    </c:if>
                </c:forEach>
                <td>${subjectName}</td>
                <td>${score.score1}</td>
                <td>${score.score2}</td>
                <td>${score.score3}</td>
                <td>${score.totalScore}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <b>GPA: ${gpa}</b>
    <p>Xuất sắc: Điểm GPA từ 3.60 – 4.00.</p>
    <p>Giỏi: Điểm GPA từ 3.20 – 3.59.</p>
    <p>Khá: Điểm GPA từ 2.50 – 3.19.</p>
    <p>Trung bình: Điểm GPA từ 2.00 – 2.49.</p>
    <p>Yếu: Điểm GPA dưới 2.00.</p>
</div>

<script>
    $(document).ready(function () {
        $('#tblScore').DataTable({
            lengthMenu: [[5, 15, 50, -1], [5, 15, 50, "All"]],
            searching: true,
            columns: [
                {searchable: false}, null, {searchable: false}, {searchable: false},
                {searchable: false}, {searchable: false}
            ],
            language: {
                "sEmptyTable": "Không có dữ liệu",
                "sInfo": "Đang hiển thị _START_ đến _END_ của _TOTAL_ mục",
                "sInfoEmpty": "Đang hiển thị 0 đến 0 của 0 mục",
                "sInfoFiltered": "(được tìm kiếm từ _MAX_ mục)",
                "sInfoPostFix": "",
                "sInfoThousands": ",",
                "sLengthMenu": "Hiển thị _MENU_ mục",
                "sLoadingRecords": "Đang tải...",
                "sProcessing": "Đang xử lý...",
                "sSearch": "Tìm kiếm:",
                "searchPlaceholder": "Nhập tên học phần",
                "sZeroRecords": "Không tìm thấy kết quả phù hợp",
                "oPaginate": {
                    "sFirst": "Đầu",
                    "sLast": "Cuối",
                    "sNext": "Tiếp",
                    "sPrevious": "Trước"
                },
                "oAria": {
                    "sSortAscending": ": Sắp xếp cột theo thứ tự tăng dần",
                    "sSortDescending": ": Sắp xếp cột theo thứ tự giảm dần"
                }
            },
        });
    })
</script>

</body>
</html>
