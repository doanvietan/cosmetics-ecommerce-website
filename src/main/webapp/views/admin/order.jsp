<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<body>
	<div class="d-flex" id="wrapper">
		<%@include file="/common/admin/header.jsp"%>
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<div class="container-fluid">
					<button class="btn btn-primary" id="sidebarToggle">Toggle
						Menu</button>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ms-auto mt-2 mt-lg-0">
							<li class="nav-item active"><a class="nav-link" href="#!">Home</a></li>
							<li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
								role="button" data-bs-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Dropdown</a>
								<div class="dropdown-menu dropdown-menu-end"
									aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="#!">Action</a> <a
										class="dropdown-item" href="#!">Another action</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#!">Something else here</a>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Page content-->
			<div class="container mt-5">
	<!-- Orders -->
	<c:forEach var="order" items="${Order}">
		<div class="card shadow-sm mb-4">
			<c:choose>
					<c:when test="${order.status eq 'completed'}">
						<div class="card-header bg-success text-white font-weight-bold">
							<div class="h5">Đơn hàng #${order.orderId}</div>
						</div>
					</c:when>
					<c:when test="${order.status eq 'canceled'}">
						<div class="card-header bg-danger text-white font-weight-bold">
							<div class="h5">Đơn hàng #${order.orderId}</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="card-header bg-warning text-dark font-weight-bold">
							<div class="h5">Đơn hàng #${order.orderId}</div>
						</div>
					</c:otherwise>
				</c:choose>

			<div class="card-body">
				<div class="row mb-3">
					<div class="col-md-4">
						<strong>Ngày giao hàng:</strong> ${order.orderDate}
					</div>
					<div class="col-md-4">
						<strong>Trạng thái:</strong>
						<c:choose>
							<c:when test="${order.status eq 'processing'}">
								<form method="post" action="admin-order">
									<input type="hidden" name="orderId" value="${order.orderId}" />
									<button type="submit" name="action" value="confirm" class="btn btn-sm btn-success">Confirm</button>
									<button type="submit" name="action" value="cancel" class="btn btn-sm btn-danger ml-2">Cancel</button>
								</form>
							</c:when>
							<c:when test="${order.status eq 'completed'}">
									<span class="badge badge-success">${order.status}</span>
							</c:when>
							<c:when test="${order.status eq 'canceled'}">
									<span class="badge badge-danger">${order.status}</span>
							</c:when>
						</c:choose>
					</div>
					<div class="col-md-4">
						<strong>Payment:</strong> ${order.paymentMethod}
					</div>
				</div>

				<table class="table table-bordered">
					<thead class="thead-light">
						<tr>
							<th scope="col">Image</th>
							<th scope="col">Product</th>
							<th scope="col" class="text-center">Quantity</th>
							<th scope="col" class="text-right">Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${order.orderItem}">
							<tr>
								<td class="align-middle text-center" style="width: 100px;">
									<img src="${pageContext.request.contextPath}/template/web/images/products/${item.productImage}"
										class="img-fluid rounded" alt="${item.productName}">
								</td>
								<td class="align-middle">${item.productName}</td>
								<td class="align-middle text-center">${item.quantity}</td>
								<td class="align-middle text-right">${item.price} VND</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3" class="text-right font-weight-bold">Total:</td>
							<td class="text-right font-weight-bold">${order.totalAmount} VND</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</c:forEach>
</div>
			

		</div>


</div>
	<%@include file="/common/admin/footer.jsp"%>
</body>
</html>