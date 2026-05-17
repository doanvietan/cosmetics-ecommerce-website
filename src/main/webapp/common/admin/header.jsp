<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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
<link rel="icon" type="image/x-icon"
	href="${ctx}/template/admin/assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${ctx}/template/admin/css/styles.css" rel="stylesheet" />
</head>
</head>
<body>
	<!-- Sidebar-->
	<div class="border-end bg-white" id="sidebar-wrapper">
		<div class="sidebar-heading border-bottom bg-light">Start Admin</div>
		<div class="list-group list-group-flush">
			<a
				class="list-group-item list-group-item-action list-group-item-light p-3"
				href="admin-product">Product</a>  <a
				class="list-group-item list-group-item-action list-group-item-light p-3"
				href="admin-user">User</a> 
				<a
				class="list-group-item list-group-item-action list-group-item-light p-3"
				href="admin-category">Category</a><a
				class="list-group-item list-group-item-action list-group-item-light p-3"
				href="admin-order">Order</a> 
				<a
				class="list-group-item list-group-item-action list-group-item-light p-3"
				href="home?action=logout">Logout</a> 
		</div>
	</div>
	<!-- Page content wrapper-->

</body>
</html>