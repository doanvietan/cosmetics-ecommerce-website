<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
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

		<div class="container mt-4">
		<div class="mb-3 d-flex justify-content-end">
		<a href="admin-edit-product?action=add" class="btn btn-success">
			<i class="fas fa-plus"></i> Thêm sản phẩm
		</a>
	</div>
			<c:forEach var="product" items="${Product}">
				<div class="card shadow-sm mb-4">
					<div class="card-header bg-info text-white font-weight-bold">
						<div class="h5 mb-0">Sản phẩm #${product.productId} - ${product.productName}</div>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-3 text-center">
								<img src="${pageContext.request.contextPath}/template/web/images/products/${product.productImage}"
									class="img-fluid rounded" alt="${product.productName}" style="max-height: 200px; max-width: 100%;">
							</div>
							<div class="col-md-9">
								<p><strong>Mô tả:</strong> ${product.productDescription}</p>
								<p><strong>Giá:</strong> ${product.productPrice} VND</p>
								<p><strong>Số lượng còn:</strong> ${product.productQuantity}</p>
								<p><strong>Đã bán:</strong> ${product.productSoldQuantity}</p>
								<p><strong>Danh mục:</strong> ${product.categoryId}</p>
								
								<div class="mt-3">
									<a href="admin-edit-product?action=edit&productId=${product.productId}" class="btn btn-sm btn-warning">Cập nhật</a>
									<a href="admin-edit-product?action=delete&productId=${product.productId}" class="btn btn-sm btn-danger ml-2">Xoá</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<%@include file="/common/admin/footer.jsp"%>
</body>
</html>