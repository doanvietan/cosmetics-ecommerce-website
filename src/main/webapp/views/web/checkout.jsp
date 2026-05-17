<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
</head>
<body>
	<%@include file="/common/web/header.jsp"%>



	<div class="page-banner-section section bg-gray">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="page-banner text-center">
						<h1>Check Out</h1>
						<ul class="page-breadcrumb">
							<li><a href="index.html">Home</a></li>
							<li>Check out</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--Checkout section start-->
	<div
		class="checkout-section section pt-30 pt-lg-80 pt-md-70 pt-sm-60 pt-xs-50 pb-70 pb-lg-50 pb-md-40 pb-sm-30 pb-xs-20">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<!-- Checkout Form Start-->
					<form action="checkout" method="post" class="checkout-form">
						<div class="row row-40">
							<div class="col-lg-7">
								<!-- Billing Address -->
								<div id="billing-form" class="mb-10">
									<h4 class="checkout-title">Billing Address</h4>
									<div class="row">
										<div class="col-md-12 col-12 mb-5">
											<label>Họ và tên*</label> <input type="text"
												placeholder="${User.userName}">
										</div>
										<div class="col-md-12 col-12 mb-5">
											<label>Email Address*</label> <input type="email"
												placeholder="${User.email}">
										</div>
										<div class="col-md-12 col-12 mb-5">
											<label>Phone no*</label> <input type="text"
												placeholder="${User.phoneNumber}">
										</div>
										<div class="col-12 mb-5">
											<label>Address*</label> <input type="text"
												placeholder="${User.address}">
										</div>
										<div class="col-12 mb-5">
											<div class="check-box">
												<input type="checkbox" id="shiping_address" data-shipping>
												<label for="shiping_address">Ship to Different
													Address</label>
											</div>
										</div>
									</div>
								</div>

								<!-- Shipping Address -->
								<div id="shipping-form">
									<h4 class="checkout-title">Shipping Address</h4>
									<div class="row">
										<div class="col-md-12 col-12 mb-5">
											<label>Họ và tên*</label> <input type="text"
												placeholder="Họ và tên">
										</div>
										<div class="col-md-12 col-12 mb-5">
											<label>Email Address*</label> <input type="email"
												placeholder="Email">
										</div>
										<div class="col-md-12 col-12 mb-5">
											<label>Phone no*</label> <input type="text"
												placeholder="Số điện thoại">
										</div>
										<div class="col-12 mb-5">
											<label>Address*</label> <input type="text"
												placeholder="Nhập địa chỉ">
										</div>
									</div>
								</div>
							</div>

							<div class="col-lg-5">
								<div class="row">
									<!-- Cart Total -->
									<div class="col-12 mb-60">
										<h4 class="checkout-title">Cart Total</h4>
										<div class="checkout-cart-total">
											<h4>
												Product <span>Total</span>
											</h4>
											<ul>
												<c:set var="total" value="0"/>
												<c:forEach var="pic" items="${ProductInCart}">
													<c:set var="subTotal" value="${pic.cartQuantity * pic.product.productPrice}"/>
													<li>${pic.product.productName} X ${pic.cartQuantity} <span>${pic.cartQuantity * pic.product.productPrice}</span></li>
													<c:set var="total" value="${total + subTotal}"/>
												</c:forEach>
											</ul>
											<p>
												Sub Total <span>${total}</span>
											</p>
											<c:set var ="ship" value="0"/>
											<p>
												Shipping Fee <span>${ship}</span>
											</p>
											<h4>
												Grand Total <span>${total + ship}</span>
											</h4>
										</div>
									</div>

									<!-- Payment Method -->
									<div class="col-12 mb-30">
										<h4 class="checkout-title">Payment Method</h4>
										<div class="checkout-payment-method">

											<div class="single-method">
												<input type="radio" id="payment_bank" name="payment-method"
													value="bank"> <label for="payment_bank">Direct
													Bank Transfer</label>
												<p data-method="bank">Please send a Check to Store name
													with Store Street, Store Town, Store State, Store Postcode,
													Store Country.</p>
											</div>

											<div class="single-method">
												<input type="radio" id="payment_cash" name="payment-method"
													value="cash"> <label for="payment_cash">Cash
													on Delivery</label>
												<p data-method="cash">Please send a Check to Store name
													with Store Street, Store Town, Store State, Store Postcode,
													Store Country.</p>
											</div>
										</div>
										<button class="place-order btn btn-lg btn-round">Place
											order</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--Checkout section end-->

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
						<a href="#"><img src="template/web/images/brands/brand-1.png"
							alt=""></a>
					</div>
					<div class="brand col">
						<a href="#"><img src="template/web/images/brands/brand-2.png"
							alt=""></a>
					</div>
					<div class="brand col">
						<a href="#"><img src="template/web/images/brands/brand-3.png"
							alt=""></a>
					</div>
					<div class="brand col">
						<a href="#"><img src="template/web/images/brands/brand-4.png"
							alt=""></a>
					</div>
					<div class="brand col">
						<a href="#"><img src="template/web/images/brands/brand-5.png"
							alt=""></a>
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