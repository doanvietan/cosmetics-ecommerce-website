package com.javaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaweb.dao.IUserDAO;
import com.javaweb.model.UserModel;
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		UserModel user = userDAO.findByUsernameAndPassword(userName, passWord);
		
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userRole", user.getRole());
			session.setAttribute("userName", user.getUserName());

			if ("admin".equalsIgnoreCase(user.getRole())) {
				resp.sendRedirect(req.getContextPath() + "/admin-product");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			req.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng!");
			req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
		}
		
	}

}
