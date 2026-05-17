<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
	<div class="d-flex" id="wrapper">
		<%@include file="/common/admin/header.jsp"%>
		<div id="page-content-wrapper">
			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<div class="container-fluid">
					<button class="btn btn-primary" id="sidebarToggle">Toggle
						Menu</button>
				</div>
			</nav>
			<div class="container mt-4">
			<div class="mb-3 d-flex justify-content-end">
		<a href="admin-edit-user?action=add" class="btn btn-success">
			<i class="fas fa-plus"></i> Thêm người dùng
		</a>
	</div>
				<c:forEach var="user" items="${UserList}">
					<div class="card shadow-sm mb-3">
						<div class="card-body">
							<h5 class="card-title">Tài khoản: ${user.userName}
								(#${user.userId})</h5>
							<p class="card-text">
								<strong>Email:</strong> ${user.email}
							</p>
							<p class="card-text">
								<strong>Số điện thoại:</strong> ${user.phoneNumber}
							</p>
							<p class="card-text">
								<strong>Địa chỉ:</strong> ${user.address}
							</p>
							<p class="card-text">
								<strong>Quyền:</strong> ${user.role}
							</p>

							<a href="admin-edit-user?action=edit&userIdd=${user.userId}"
								class="btn btn-warning btn-sm">Cập nhật</a> <a
								href="admin-edit-user?action=delete&userIdd=${user.userId}"
								class="btn btn-danger btn-sm ml-2">Xoá</a>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<%@include file="/common/admin/footer.jsp"%>
</body>
</html>