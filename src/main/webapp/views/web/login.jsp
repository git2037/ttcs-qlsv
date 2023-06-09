<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Đăng nhập</title>

    <link href="<c:url value="/template/web/assets/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/web/assets/css/style.css"/>" rel="stylesheet">
</head>

<body>
<main id="main">
    <section class="vh-100">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                         class="img-fluid" alt="Sample image">
                </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                    <form action="<c:url value="/dang-nhap"/>" method="post"
                          class="needs-validate" novalidate>
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger" role="alert">
                                <p class="text-center">${error}</p>
                            </div>
                        </c:if>
                        <h2>
                            <p class="text-center">Đăng nhập</p>
                        </h2>

                        <div class="form-floating mb-3">

                            <input type="text" class="form-control" id="userNameInput"
                                   name="userName" placeholder="Tên đăng nhập" required>
                            <label for="userNameInput">Tên đăng nhập</label>
                            <div class="invalid-feedback">
                                Tên đăng nhập không để trống và không chứa dấu cách!
                            </div>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" id="PasswordInput"
                                   name="password" placeholder="Mật khẩu" required>
                            <label for="PasswordInput">Mật khẩu</label>
                            <div class="invalid-feedback">
                                Mật khẩu không để trống!
                            </div>
                        </div>

                        <div class="d-grid gap-2 col-6 mx-auto">
                            <button class="btn btn-primary" type="submit">Đăng nhập</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </section>
</main>

<script>
    (function () {
        'use strict'

        var forms = document.querySelectorAll('.needs-validation')

        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    event.preventDefault(); // Ngăn chặn form submit mặc định

                    var userNameInput = document.getElementById('userNameInput');
                    var passwordInput = document.getElementById('PasswordInput');

                    // Kiểm tra ô tên đăng nhập không được để trống và không chứa dấu cách
                    if (userNameInput.value.trim() === '' || userNameInput.value.includes(' ')) {
                        userNameInput.classList.add('is-invalid');
                        return;
                    } else {
                        userNameInput.classList.remove('is-invalid');
                    }

                    // Kiểm tra ô mật khẩu không được để trống
                    if (passwordInput.value.trim() === '') {
                        passwordInput.classList.add('is-invalid');
                        return;
                    } else {
                        passwordInput.classList.remove('is-invalid');
                    }

                    // Nếu tất cả các kiểm tra thành công, có thể submit form
                    this.submit();
                }, false)
            })
    })()
</script>

</body>

</html>