package com.javaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.dao.IProductDAO;
@WebServlet(urlPatterns ="/admin-product")
public class ProductController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDAO productDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("Product", productDAO.productFindAll());
		req.getRequestDispatcher("views/admin/product.jsp").forward(req, resp);
	}
}
