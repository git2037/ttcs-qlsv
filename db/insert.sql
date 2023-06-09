use qlsv;

insert into vaitro(maVT, tenVT)
VALUES ('admin', 'Quản trị hệ thống'), ('student', 'Sinh viên');

insert into taikhoan(tenDangNhap, matKhau, idVT)
VALUES ('admin', 'admin', 1);

insert into admin(maAD, hoVaTen, gioiTinh, diaChi, ngaySinh, trangThai, idTK)
VALUES ('admin', 'Admin', 'Nam', 'Hà Nội', '2000-01-01', 1, 1);