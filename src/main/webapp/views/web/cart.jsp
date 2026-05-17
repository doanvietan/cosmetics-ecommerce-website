<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<%@include file="/common/web/header.jsp"%>

	<div class="page-banner-section section bg-gray">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="page-banner text-center">
						<h1>Shopping Cart</h1>
						<ul class="page-breadcrumb">
							<li><a href="index.html">Home</a></li>
							<li>Cart</li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!--Cart section start-->
	<div
		class="cart-section section pt-30 pt-lg-80 pt-md-70 pt-sm-60 pt-xs-50  pb-70 pb-lg-50 pb-md-40 pb-sm-30 pb-xs-20">
		<div class="container">
			<div class="row">

				<div class="col-12">
					<!-- Cart Table -->
					<div class="cart-table table-responsive mb-30">
						<form action="cart" method="post">
							<table class="table">
								<thead>
									<tr>
										<th class="pro-thumbnail">Image</th>
										<th class="pro-title">Product</th>
										<th class="pro-price">Price</th>
										<th class="pro-quantity">Quantity</th>
										<th class="pro-subtotal">Total</th>
										<th class="pro-remove">Remove</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="totalAmount" value="0" />
									<c:forEach var="pic" items="${ProductInCart}">
										<c:set var="subtotal"
											value="${pic.product.productPrice * pic.cartQuantity}" />
										<c:set var="totalAmount" value="${totalAmount + subtotal}" />
										<tr>
											<td class="pro-thumbnail"><a href="#"><img
													src="${pageContext.request.contextPath}/template/web/images/products/${pic.product.productImage}"
													alt="Product"></a></td>
											<td class="pro-title"><a href="#">${pic.product.productName}</a></td>
											<td class="pro-price"><span>${pic.product.productPrice}</span></td>
											<td class="pro-quantity">
													<a href="cart?action=dec&productId=${pic.product.productId}" class="dec qtybtn">-</a>
													<input type="number" value="${pic.cartQuantity}"> 
													<a href="cart?action=inc&productId=${pic.product.productId}" class="inc qtybtn">+</a>

											</td>
											<td class="pro-subtotal"><span>${pic.product.productPrice * pic.cartQuantity}VND</span></td>
											<td class="pro-remove"><a
												href="cart?action=delete&productId=${pic.product.productId}"><i
													class="fa fa-trash-o"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="4" class="text-right">
											<h4 style="line-height: 45px;">Tổng:</h4>
										</td>
										<td class="text-center"><h4 style="line-height: 45px;">${totalAmount}VND</h4></td>
										<td class="text-center">
											<div class="cart-summary-button">
												<a style="color: #fff;" class="btn" href="checkout">Checkout</a>
											</div>
										</td>
									</tr>
								</tfoot>
							</table>
						</form>

					</div>


				</div>

			</div>
		</div>
	</div>
	<!--Cart section end-->

	<!--Brand section start-->
	<div
		class="brand-section section border-top pt-90 pt-lg-70 pt-md-65 pt-sm-55 pt-xs-40 pb-100 pb-lg-80 pb-md-70 pb-sm-60 pb-xs-50">
		<div class="container">
			<div class="row">

				<!--Brand Slider start-->
				<div class="tf-element-carousel section"
					data-slick-options='{
                "slidesToShow": 5,
                "slidesToScroll": 1,
                "infinite": true,
                "arrows": false,
                "autoplay": true
                }'
					data-slick-responsive='[
                {"breakpoint":1199, "settings": {
                "slidesToShow": 4
                }},
                {"breakpoint":992, "settings": {
                "slidesToShow": 4
                }},
                {"breakpoint":768, "settings": {
                "slidesToShow": 3
                }},
                {"breakpoint":576, "settings": {
                "slidesToShow": 1
                }}
                ]'>
					<div class="brand col">
						<a href="#"><img src="assets/images/brands/brand-1.png" alt=""></a>
					</div>
					<div class="brand col">
						<a href="#"><img src="assets/images/brands/brand-2.png" alt=""></a>
					</div>
					<div class="brand col">
						<a href="#"><img src="assets/images/brands/brand-3.png" alt=""></a>
					</div>
					<div class="brand col">
						<a href="#"><img src="assets/images/brands/brand-4.png" alt=""></a>
					</div>
					<div class="brand col">
						<a href="#"><img src="assets/images/brands/brand-5.png" alt=""></a>
					</div>
				</div>
				<!--Brand Slider end-->

			</div>
		</div>
	</div>
	<!--Brand section end-->

	<%@include file="/common/web/footer.jsp"%>
</body>
</html>