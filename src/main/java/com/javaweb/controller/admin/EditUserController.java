package com.javaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.dao.IUserDAO;
import com.javaweb.model.UserModel;

@WebServlet(urlPatterns ="/admin-edit-user")
public class EditUserController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter("userIdd");
		String action = req.getParameter("action");
		if ("delete".equals(action) && userIdStr != null) {
	        try {
	            int userId = Integer.parseInt(userIdStr);
	            userDAO.deleteUser(userId);
	            resp.sendRedirect("admin-user"); // quay lại trang danh sách sau khi xoá
	            return;
	        } catch (NumberFormatException e) {
	            req.setAttribute("error", "ID người dùng không hợp lệ.");
	        }
	    } else if ("edit".equals(action) && userIdStr != null) {
	        try {
	            int userId = Integer.parseInt(userIdStr);
	            req.setAttribute("userIdd", userId);
	        } catch (NumberFormatException e) {
	            req.setAttribute("error", "ID người dùng không hợp lệ.");
	        }
	    }
		req.getRequestDispatcher("/views/admin/edituser.jsp").forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");

	    String userIdStr = req.getParameter("userIdd");

	    UserModel user = new UserModel();
	    user.setUserName(req.getParameter("userName"));
	    user.setEmail(req.getParameter("email"));
	    user.setPassWord(req.getParameter("passWord"));
	    user.setPhoneNumber(req.getParameter("phoneNumber"));
	    user.setAddress(req.getParameter("address"));
	    user.setRole(req.getParameter("role"));

	    try {
	        if (userIdStr != null && !userIdStr.isEmpty()) {
	            int userId = Integer.parseInt(userIdStr);
	            if (userId > 0) {
	                user.setUserId(userId);
	                userDAO.updateUser(user); // update nếu userId > 0
	            } else {
	                userDAO.insertUser(user); // insert nếu userId <= 0
	            }
	        } else {
	            userDAO.insertUser(user); // insert nếu không có userId
	        }
	    } catch (NumberFormatException e) {
	        req.setAttribute("error", "ID người dùng không hợp lệ.");
	        req.getRequestDispatcher("/views/admin/edituser.jsp").forward(req, resp);
	        return;
	    }
	    
	    resp.sendRedirect("admin-user");

	}
}
