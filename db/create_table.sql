create database if not exists qlsv;
USE qlsv;

/* vaiTro 1 - n taikhoan
   admin 1 - 1 tai khoan
   lophoc n - 1 khoahoc
   sinhvien n - 1 lophoc
   sinhvien 1-1 taikhoan
   diem n - 1 sinh vien
   diem n - 1 hocphan
   thongbao n - 1 sinhvien
   thongbao n - 1 admin
 */

CREATE TABLE IF NOT EXISTS `qlsv`.`vaitro`
(
    `idVT`  INT PRIMARY KEY AUTO_INCREMENT,
    `maVT`  VARCHAR(10) NOT NULL UNIQUE,
    `tenVT` VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS `qlsv`.`taikhoan`
(
    `idTK`        INT PRIMARY KEY AUTO_INCREMENT,
    `tenDangNhap` VARCHAR(10) NOT NULL UNIQUE,
    `matKhau`     VARCHAR(20),
    `idVT`        INT         NOT NULL
    );

CREATE TABLE IF NOT EXISTS `qlsv`.`admin`
(
    `idAD`      INT PRIMARY KEY AUTO_INCREMENT,
    `maAD`      VARCHAR(10) NOT NULL UNIQUE,
    `hoVaTen`   VARCHAR(50),
    `gioiTinh`  VARCHAR(5),
    `diaChi`    VARCHAR(50),
    `ngaySinh`  DATE,
    `trangThai` INT,
    `idTK`      INT         NOT NULL
    );

CREATE TABLE IF NOT EXISTS `qlsv`.`hocphan`
(
    `idHP`     INT PRIMARY KEY AUTO_INCREMENT,
    `maHP`     VARCHAR(10) NOT NULL UNIQUE,
    `tenHP`    VARCHAR(50),
    `soTinChi` INT
    );

CREATE TABLE IF NOT EXISTS `qlsv`.`khoahoc`
(
    `idKH` INT PRIMARY KEY AUTO_INCREMENT,
    `maKH` VARCHAR(7) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS `qlsv`.`lophoc`
(
    `idLH`  INT PRIMARY KEY AUTO_INCREMENT,
    `maLH`  VARCHAR(10) NOT NULL UNIQUE,
    `tenLH` VARCHAR(10),
    `idKH`  INT        NOT NULL
    );

CREATE TABLE IF NOT EXISTS `qlsv`.`sinhvien`
(
    `idSV`      INT PRIMARY KEY AUTO_INCREMENT,
    `maSV`      VARCHAR(10) NOT NULL UNIQUE,
    `hoVaTen`   VARCHAR(50),
    `gioiTinh`  VARCHAR(10),
    `diaChi`    VARCHAR(50),
    `ngaySinh`  DATE        NULL,
    `trangThai` INT         NULL,
    `idTK`      INT         NOT NULL,
    `idLH`      INT         NOT NULL
    );

CREATE TABLE IF NOT EXISTS `qlsv`.`diem`
(
    `idD`    INT PRIMARY KEY AUTO_INCREMENT,
    `diemGK` DOUBLE,
    `diemCC` DOUBLE,
    `diemCK` DOUBLE,
    `diemTK` DOUBLE,
    `idSV`   INT NOT NULL,
    `idHP`   INT NOT NULL
);

CREATE TABLE IF NOT EXISTS `qlsv`.`thongbao`
(
    `idTB`      INT PRIMARY KEY AUTO_INCREMENT,
    `noiDung`   TEXT 		 NOT NULL,
    `trangThai` INT          NULL,
    `idAD`      INT          NOT NULL,
    `idSV`      INT          NOT NULL
    );

ALTER TABLE taikhoan
    add CONSTRAINT fk_taiKhoan_vaiTro FOREIGN KEY (idVT) references vaitro(idVT);

ALTER TABLE admin
    ADD CONSTRAINT fk_admin_taiKhoan foreign key (idTK) references taikhoan(idTK);

alter table lophoc
    add constraint fk_lh_kh foreign key (idKH) references lophoc(idLH);

alter table sinhvien
    add constraint fk_sv_tk foreign key (idTK) references taikhoan(idTK);

alter table sinhvien
    add constraint fk_sv_lh foreign key (idLH) references lophoc(idLH);

alter table sinhvien
    add constraint uc_sv unique (idLH, idTK);

alter table diem
    add constraint fk_diem_sv foreign key (idSV) references sinhvien(idSV);

alter table diem
    add constraint fk_diem_hp foreign key (idHP) references hocphan(idHP);

alter table diem
    add constraint uc_diem unique (idSV, idHP);

alter table thongbao
    add constraint foreign key (idSV) references sinhvien(idSV);

alter table thongbao
    add constraint  foreign key (idAD) references admin(idAD);