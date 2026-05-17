<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">

<!-- Favicon (nếu dùng) -->
<!-- <link href="<c:url value='/assets/images/favicon.ico' />" type="image/x-icon" rel="shortcut icon"> -->

<!-- FontAwesome -->
<script src="https://kit.fontawesome.com/8c204d0fdf.js" crossorigin="anonymous"></script>

<!-- CSS files -->
<link rel="stylesheet"
	href="<c:url value='/template/web/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/iconfont.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/plugins.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/helper.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/style.css'/>">

<!-- Modernizr -->
<script src="<c:url value='/assets/js/vendor/modernizr-2.8.3.min.js'/>"></script>

<title>Trang chủ</title>
</head>
<body>
	<header class="header header-transparent header-sticky">
		<div class="header-top">
			<div class="container">
				<div class="row align-items-center">
					<div
						class="col-xl-6 col-lg-8 d-flex flex-wrap justify-content-lg-start justify-content-center align-items-center">
						<!--Links start-->
						<div class="header-top-links">
							<ul>
								<li><a href="#"><i class="fa fa-phone"></i>(08) 123 456
										7890</a></li>
								<li><a href="#"><i class="fa fa-envelope-open-o"></i>yourmail@domain.com</a></li>
							</ul>
						</div>
						<!--Links end-->
					</div>
					<div class="col-xl-6 col-lg-4">
						<div
							class="ht-right d-flex justify-content-lg-end justify-content-center">
							<ul class="ht-us-menu d-flex">
								<li><a href="#">${sessionScope.userName}<i class="fa fa-user-circle-o"></i>Login</a>
									<ul class="ht-dropdown right">
										<li><a href="my-account.html">My Account</a></li>
										<li><a href="login">Sign In</a></li>
										<li><a href="<c:url value='/home?action=logout'/>">Logout</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>

		<div class="header-bottom menu-right">
			<div class="container">
				<div class="row align-items-center">

					<!--Logo start-->
					<div class="col-lg-3 col-md-3 col-6 order-lg-1 order-md-1 order-1">
						<div class="logo">
							<a href="<c:url value='/home'/>"><img
								src="<c:url value='/template/web/images/logo.png'/>"
								alt="logo TG shop"></a>
						</div>
					</div>
					<!--Logo end-->

					<!--Menu start-->
					<div
						class="col-lg-6 col-md-6 col-12 order-lg-2 order-md-2 order-3 d-flex justify-content-center">
						<nav class="main-menu">
							<ul>
								<li><a href="<c:url value='/home'/>">Home</a></li>
								<li><a href="<c:url value='/order'/>">Order</a></li>
								<li><a href="<c:url value='/about'/>">About Us</a></li>
								<li><a href="<c:url value='/contact'/>">Contact Us</a></li>
							</ul>
						</nav>
					</div>
					<!--Menu end-->

					<!--Search Cart Start-->
					<div
						class="col-lg-3 col-md-3 col-6 order-lg-3 order-md-3 order-2 d-flex justify-content-end">
						<div class="header-search">
							<button class="header-search-toggle">
								<i class="fa fa-search"></i>
							</button>
							<div class="header-search-form">
								<form action="#">
									<input type="text" placeholder="Type and hit enter">
									<button>
										<i class="fa fa-search"></i>
									</button>
								</form>
							</div>
						</div>
						<div class="header-cart">
							<a href="<c:url value='/cart'/>"><i
								class="fa fa-shopping-cart"></i><span>3</span></a>
						</div>
					</div>
					<!--Search Cart End-->
				</div>

				<!--Mobile Menu start-->
				<div class="row">
					<div class="col-12 d-flex d-lg-none">
						<div class="mobile-menu"></div>
					</div>
				</div>
				<!--Mobile Menu end-->
			</div>
		</div>
	</header>
</body>