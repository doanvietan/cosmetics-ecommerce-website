<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Trang chủ</title>
	<link rel="stylesheet" href="<c:url value='/template/web/css/style.css'/>" />
	<style>
		table {
			width: 100%;
			border-collapse: collapse;
			margin: 20px 0;
			font-family: Arial, sans-serif;
		}
		th, td {
			border: 1px solid #dddddd;
			text-align: left;
			padding: 12px;
		}
		th {
			background-color: #4CAF50;
			color: white;
		}
		tr:nth-child(even) {
			background-color: #f2f2f2;
		}
		tr:hover {
			background-color: #ddd;
		}
		tfoot {
			background-color: #f9f9f9;
			font-weight: bold;
		}
		h1 {
			text-align: center;
		}
	</style>
	</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>Số CMND</th>
                <th>Họ Tên</th>
                <th>Email</th>
                <th>Địa Chỉ</th>
                <th>Số Điện Thoại</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="sinhVien" items="${SinhVien}">
                <tr>
                    <td>${sinhVien.soCMND}</td>
                    <td>${sinhVien.hoTen}</td>
                    <td>${sinhVien.email}</td>
                    <td>${sinhVien.diaChi}</td>
                    <td>${sinhVien.soDT}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <%@include file="/common/footer.jsp"%>
</body>
</html>