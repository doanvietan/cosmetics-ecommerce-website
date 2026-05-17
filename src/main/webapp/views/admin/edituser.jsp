<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm / Cập nhật Người dùng</title>
    <style>
        .form-container {
            max-width: 700px;
            margin: 50px auto;
            border: 1px solid #ddd;
            padding: 30px;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="d-flex" id="wrapper">
    <%@include file="/common/admin/header.jsp"%>

    <div id="page-content-wrapper">
        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
            <div class="container-fluid">
                <button class="btn btn-primary" id="sidebarToggle">Toggle Menu</button>
            </div>
        </nav>

        <div class="form-container">
            <h3 class="text-center mb-4">Thêm / Cập nhật Người dùng</h3>

            <form action="admin-edit-user" method="post">
                <!-- ID ẩn khi cập nhật -->
                <input type="hidden" name="userIdd" value="${userIdd}" />

                <!-- Tên người dùng -->
                <div class="mb-3">
                    <label for="userName" class="form-label">Tên đăng nhập</label>
                    <input type="text" class="form-control" id="userName" name="userName" value="${user.userName}" required />
                </div>

                <!-- Email -->
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="${user.email}" required />
                </div>

                <!-- Mật khẩu -->
                <div class="mb-3">
                    <label for="passWord" class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" id="passWord" name="passWord" value="${user.passWord}" required />
                </div>

                <!-- Số điện thoại -->
                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Số điện thoại</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}" />
                </div>

                <!-- Địa chỉ -->
                <div class="mb-3">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <textarea class="form-control" id="address" name="address" rows="2">${user.address}</textarea>
                </div>

                <!-- Vai trò -->
                <div class="mb-3">
                    <label for="role" class="form-label">Quyền</label>
                    <select class="form-select" id="role" name="role" required>
                        <option value="">-- Chọn quyền --</option>
                        <option name="admin" value="admin" >Admin</option>
                        <option name="user" value="user">User</option>
                    </select>
                </div>

                <!-- Nút -->
                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-success">Lưu</button>
                    <a href="admin-user" class="btn btn-secondary">Hủy</a>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="/common/admin/footer.jsp"%>
</body>
</html>
