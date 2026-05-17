<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm/Cập nhật sản phẩm</title>
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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

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

			<div class="form-container">
				<h3 class="text-center mb-4">Thêm / Cập nhật sản phẩm</h3>

				<form action="admin-edit-product" method="post" enctype="multipart/form-data">
					<!-- Tên sản phẩm -->
					<div class="mb-3">
						<label for="productName" class="form-label">Tên sản phẩm</label> <input
							type="text" class="form-control" id="productName"
							name="productName" required>
					</div>
					<input type="hidden" name="productId" value="${productId}">
					<!-- Mô tả sản phẩm -->
					<div class="mb-3">
						<label for="productDescription" class="form-label">Mô tả</label>
						<textarea class="form-control" id="productDescription"
							name="productDescription" rows="3" required></textarea>
					</div>

					<!-- Giá -->
					<div class="mb-3">
						<label for="productPrice" class="form-label">Giá (VND)</label> <input
							type="number" class="form-control" id="productPrice"
							name="productPrice" required>
					</div>

					<!-- Số lượng -->
					<div class="mb-3">
						<label for="productQuantity" class="form-label">Số lượng</label> 
						<input type="number" class="form-control"
							id="productQuantity" name="productQuantity" required>
					</div>

					<!-- Đã bán -->

					<!-- Danh mục -->
					<div class="mb-3">
						<label for="categoryId" class="form-label">Danh mục</label> <select
							class="form-select" id="categoryId" name="categoryId" required>
							<option value="">-- Chọn danh mục --</option>
							<option value="1">Trang điểm</option>
							<option value="2">Chăm sóc da</option>
							<option value="3">Dụng cụ</option>
							<!-- Bạn có thể thêm danh mục khác ở đây -->
						</select>
					</div>

					<!-- Hình ảnh -->
					<div class="mb-3">
						<label for="productImage" class="form-label">Hình ảnh</label> <input
							type="file" class="form-control" id="productImage"
							name="productImage">
					</div>

					<!-- Nút -->
					<div class="d-flex justify-content-between">
						<button type="submit" class="btn btn-success">Lưu</button>
						<a href="admin-product" class="btn btn-secondary">Hủy</a>
					</div>
				</form>
			</div>
		</div>
	</div>
			<%@include file="/common/admin/footer.jsp"%>
</body>
</html>