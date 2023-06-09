// Call the dataTables jQuery plugin
$(document).ready(function() {
  const exportButtons = $('#exportButtons');

  const tblStudent = $('#tblStudent');
  tblStudent.DataTable({
    buttons: [
      {
        extend: 'excelHtml5',
        exportOptions: {
          columns: [0, 1, 2, 3, 4, 5, 6]
        },
        text: '<i class="fas fa-file-excel"></i> ',
        titleAttr: 'Xuất file Excel',
        className: 'btn btn-success',
      },
      {
        extend: 'pdfHtml5',
        exportOptions: {
          columns: [0, 1, 2, 3, 4, 5, 6]
        },
        text: '<i class="fas fa-file-pdf"></i> ',
        titleAttr: 'Xuất file PDF',
        className: 'btn btn-danger',
      },
    ],
    columnDefs: [
      { targets: [7], orderable: false }
    ],
    lengthMenu: [[5, 15, 50, -1], [5, 15, 50, "All"]],
    searching: true,
    columns: [
      { searchable: false }, null, { searchable: false }, { searchable: false },
      { searchable: false },{ searchable: false }, { searchable: false }, { searchable: false }
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
      "searchPlaceholder": "Nhập mã sinh viên",
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
  exportButtons.append(tblStudent.DataTable().buttons().container());

  const tblClass = $('#tblClass');
  tblClass.DataTable({
    buttons: [
      {
        extend: 'excelHtml5',
        exportOptions: {
          columns: [0, 1, 2, 3]
        },
        text: '<i class="fas fa-file-excel"></i> ',
        titleAttr: 'Xuất file Excel',
        className: 'btn btn-success',
      },
      {
        extend: 'pdfHtml5',
        exportOptions: {
          columns: [0, 1, 2, 3]
        },
        text: '<i class="fas fa-file-pdf"></i> ',
        titleAttr: 'Xuất file PDF',
        className: 'btn btn-danger',
      },
    ],
    columnDefs: [
      { targets: [4], orderable: false }
    ],
    lengthMenu: [[5, 15, 50, -1], [5, 15, 50, "All"]],
    searching: true,
    columns: [
      { searchable: false }, { searchable: false }, null, { searchable: false }, { searchable: false }
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
      "searchPlaceholder": "Nhập tên lớp học",
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
  exportButtons.append(tblClass.DataTable().buttons().container());

  const tblCourse = $('#tblCourse');
  tblCourse.DataTable({
    buttons: [
      {
        extend: 'excelHtml5',
        exportOptions: {
          columns: [0, 1]
        },
        text: '<i class="fas fa-file-excel"></i> ',
        titleAttr: 'Xuất file Excel',
        className: 'btn btn-success',
      },
      {
        extend: 'pdfHtml5',
        exportOptions: {
          columns: [0, 1]
        },
        text: '<i class="fas fa-file-pdf"></i> ',
        titleAttr: 'Xuất file PDF',
        className: 'btn btn-danger',
      },
    ],
    columnDefs: [
      { targets: [2], orderable: false }
    ],
    lengthMenu: [[5, 15, 50, -1], [5, 15, 50, "All"]],
    searching: true,
    columns: [
      { searchable: false }, null, { searchable: false }
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
      "searchPlaceholder": "Nhập mã khóa học",
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
  exportButtons.append(tblCourse.DataTable().buttons().container());

  const tblSubject = $('#tblSubject');
  tblSubject.DataTable({
    buttons: [
      {
        extend: 'excelHtml5',
        exportOptions: {
          columns: [0, 1, 2, 3]
        },
        text: '<i class="fas fa-file-excel"></i> ',
        titleAttr: 'Xuất file Excel',
        className: 'btn btn-success',
      },
      {
        extend: 'pdfHtml5',
        exportOptions: {
          columns: [0, 1, 2, 3]
        },
        text: '<i class="fas fa-file-pdf"></i> ',
        titleAttr: 'Xuất file PDF',
        className: 'btn btn-danger',
      },
    ],
    columnDefs: [
      { targets: [4], orderable: false }
    ],
    lengthMenu: [[5, 15, 50, -1], [5, 15, 50, "All"]],
    searching: true,
    columns: [
      { searchable: false }, null, { searchable: false }, { searchable: false }, { searchable: false }
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
      "searchPlaceholder": "Nhập mã học phần",
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
  exportButtons.append(tblSubject.DataTable().buttons().container());

  const tblScore = $('#tblScore');
  tblScore.DataTable({
    buttons: [
      {
        extend: 'excelHtml5',
        exportOptions: {
          columns: [0, 1, 2, 3, 4, 5, 6]
        },
        text: '<i class="fas fa-file-excel"></i> ',
        titleAttr: 'Xuất file Excel',
        className: 'btn btn-success',
      },
      {
        extend: 'pdfHtml5',
        exportOptions: {
          columns: [0, 1, 2, 3, 4, 5, 6]
        },
        text: '<i class="fas fa-file-pdf"></i> ',
        titleAttr: 'Xuất file PDF',
        className: 'btn btn-danger',
      },
    ],
    columnDefs: [
      { targets: [7], orderable: false }
    ],
    lengthMenu: [[5, 15, 50, -1], [5, 15, 50, "All"]],
    searching: true,
    columns: [
      { searchable: false }, null, null, { searchable: false }, { searchable: false }, { searchable: false }, { searchable: false },
      { searchable: false }
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
      "searchPlaceholder": "Nhập mã hp hoặc mã sv",
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
  exportButtons.append(tblScore.DataTable().buttons().container());
});
