package com.javaweb.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.javaweb.dao.IProductDAO;
import com.javaweb.model.ProductModel;
@MultipartConfig
@WebServlet(urlPatterns ="/admin-edit-product")
public class EditProductController extends HttpServlet{
	@Inject
	private IProductDAO productDAO;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String action = req.getParameter("action");

		    if ("edit".equals(action)) {
		        String productIdStr = req.getParameter("productId");

		        if (productIdStr != null) {
		            int productId = Integer.parseInt(productIdStr);

		            // Lấy thông tin sản phẩm từ DB
		            req.setAttribute("productId", productId);
		        }

		        req.getRequestDispatcher("/views/admin/editproduct.jsp").forward(req, resp);

		    } else if ("delete".equals(action)) {
		        String productIdStr = req.getParameter("productId");

		        if (productIdStr != null) {
		            int productId = Integer.parseInt(productIdStr);
		            productDAO.productDelete(productId); // Gọi hàm xoá
		        }

		        resp.sendRedirect("admin-product");
		    } else {
		        req.getRequestDispatcher("views/admin/editproduct.jsp").forward(req, resp);
		    }
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    String productIdStr = req.getParameter("productId");
        
	    String name = req.getParameter("productName");
	    String description = req.getParameter("productDescription");

	    // Kiểm tra các tham số trước khi chuyển đổi
	    String priceParam = req.getParameter("productPrice");
	    String quantityParam = req.getParameter("productQuantity");
	    String categoryIdParam = req.getParameter("categoryId");

	    // Nếu có tham số nào bị rỗng hoặc null thì báo lỗi
	    if (priceParam == null || priceParam.isEmpty() || quantityParam == null || quantityParam.isEmpty() || categoryIdParam == null || categoryIdParam.isEmpty()) {
	        req.setAttribute("error", "Tất cả các trường phải được điền đầy đủ!");
	        req.getRequestDispatcher("views/admin/editproduct.jsp").forward(req, resp);
	        return;
	    }

	    // Chuyển đổi các tham số thành số nguyên
	    int price = Integer.parseInt(priceParam);
	    int quantity = Integer.parseInt(quantityParam);
	    int categoryId = Integer.parseInt(categoryIdParam);

	    Part filePart = req.getPart("productImage");
	    String imageFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

	    // Xử lý ảnh
	    String uploadPath = getServletContext().getRealPath("template/web/images/products");
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) uploadDir.mkdirs();
	    filePart.write(uploadPath + File.separator + imageFileName);

	    // Tạo đối tượng ProductModel
	    ProductModel product = new ProductModel();
	    product.setProductName(name);
	    product.setProductDescription(description);
	    product.setProductPrice(price);
	    product.setProductQuantity(quantity);
	    product.setProductImage(imageFileName);
	    product.setCategoryId(categoryId);
	    if(productIdStr != null) {
	    	int productId = Integer.parseInt(productIdStr);
	    	product.setProductId(productId);
	    	productDAO.productUpdate(product);
	    	resp.sendRedirect("admin-product");
	    }else {
	    	productDAO.productInsert(product);
	    	resp.sendRedirect("admin-product");
	    }
	}


}
