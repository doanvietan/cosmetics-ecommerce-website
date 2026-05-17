<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">

<title>Order</title>
</head>
<body>
	<%@include file="/common/web/header.jsp"%>
	<div class="page-banner-section section bg-gray">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="page-banner text-center">
						<h1>Order</h1>
						<ul class="page-breadcrumb">
							<li><a href="index.html">Home</a></li>
							<li>Order</li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>

	<div class="container mt-5">
		<!-- Đơn hàng -->
		<c:forEach var="order" items="${Order}">
			<div class="card shadow-sm">

				<c:choose>
					<c:when test="${order.status eq 'completed'}">
						<div class="card-header bg-success text-white font-weight-bold">
							<div class="h5">Order #${order.orderId}</div>
						</div>
					</c:when>
					<c:when test="${order.status eq 'canceled'}">
						<div class="card-header bg-danger text-white font-weight-bold">
							<div class="h5">Order #${order.orderId}</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="card-header bg-warning text-dark font-weight-bold">
							<div class="h5">Order #${order.orderId}</div>
						</div>
					</c:otherwise>
				</c:choose>

				<div class="card-body">
					<div class="row">
						<div class="col-md-4">
							<strong>Ngày Đặt:</strong> ${order.orderDate}
						</div>
						<div class="col-md-4">
							<strong>Trạng Thái:</strong>
							<c:choose>
								<c:when test="${order.status eq 'completed'}">
									<span class="badge badge-success">${order.status}</span>
								</c:when>
								<c:when test="${order.status eq 'canceled'}">
									<span class="badge badge-danger">${order.status}</span>
								</c:when>
								<c:otherwise>
									<span class="badge badge-warning">${order.status}</span>
								</c:otherwise>
							</c:choose>

						</div>
						<div class="col-md-4">
							<strong>Phương thức thanh toán:</strong> ${order.paymentMethod}
						</div>
					</div>

					<table class="table table-bordered mt-4">
						<thead class="thead-light">
							<tr>
								<th scope="col">Hình Ảnh</th>
								<th scope="col">Tên Sản Phẩm</th>
								<th scope="col" class="text-center">Số Lượng</th>
								<th scope="col" class="text-right">Thành Tiền</th>
							</tr>
						</thead>
						<c:forEach var="item" items="${order.orderItem}">

							<tbody>
								<tr>
									<td class="align-middle text-center" style="width: 100px;">
										<img
										src="${pageContext.request.contextPath}/template/web/images/products/${item.productImage}"
										class="img-fluid rounded" alt="Sản phẩm 1">
									</td>
									<td class="align-middle">${item.productName }</td>
									<td class="align-middle text-center">${item.quantity}</td>
									<td class="align-middle text-right">${item.price}VND</td>
								</tr>
							</tbody>
						</c:forEach>

						<tfoot>
							<tr>
								<td colspan="3" class="text-right font-weight-bold">Tổng
									Tiền:</td>
								<td class="text-right font-weight-bold">${order.totalAmount}
									VND</td>
							</tr>
						</tfoot>
					</table>


				</div>
			</div>
		</c:forEach>

		<!-- Đơn hàng khác -->

	</div>


	<%@include file="/common/web/footer.jsp"%>

</body>
</html>