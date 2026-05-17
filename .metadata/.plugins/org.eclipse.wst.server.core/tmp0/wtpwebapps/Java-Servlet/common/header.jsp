<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header {
            background-color: #4CAF50;
            padding: 20px 0;
            text-align: center;
            color: white;
        }
        header h1 {
            margin-bottom: 10px;
        }
        nav a {
            color: white;
            margin: 0 15px;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
</style>
</head>
<body>
	<header>
		<h1>Hệ thống đăng ký thông tin</h1>
		<nav>
			<a href="<c:url value='/trang-chu'/>">Trang chủ</a>
			<a href="<c:url value='/form'/>">Sinh Viên</a>
			<a href="#">Liên hệ</a>
		</nav>
	</header>
</body>
</html>