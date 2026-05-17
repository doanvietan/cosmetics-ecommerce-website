<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Hoá Đơn</title>
    <style>
        form {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            padding-right: 40px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        select, Textarea{
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        h1{
            text-align: center;
            color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Thông tin hoá đơn</h1>
    <form action="" method="post">
    	<label for="mahd">Mã hoá đơn</label>
    	<input type="text" name="maHD">
        <label>Mã nhân viên</label>
        <select name="maNV">
            <c:forEach var="NhanVien" items="${NhanVien}">
                <option value="${NhanVien.maNVV}">${NhanVien.maNVV}</option>
            </c:forEach>
        </select><br>
        <label>Mã Khách Hàng</label>
        <select name="maKH">
            <c:forEach var="KhachHang" items="${KhachHang}">
                <option value="${KhachHang.maKHH}">${KhachHang.maKHH}</option>
            </c:forEach>
        </select><br>
        <label>Phương Thức Thanh Toán</label>
        <select name="pttt">
            <option value="tienMat">Tiền mặt</option>
            <option value="chuyenKhoan">Chuyển khoản</option>
        </select>  
        <label>Tên sản phẩm</label>
        <select name="tenSP">
            <c:forEach var="SanPham" items="${SanPham}">
                <option value="${SanPham.tenSP}">${SanPham.tenSP}</option>
            </c:forEach>
        </select><br>
        <label>Số lượng sản phẩm</label>
        <input type="text" name="soLuong" ></input> <br> 
        <input type="hidden" name="action" value="add">
        <input type="submit" value="Thêm sản phẩm">
    </form>
</body>
</html>