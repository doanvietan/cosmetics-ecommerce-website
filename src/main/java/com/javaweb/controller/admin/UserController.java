package com.javaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.dao.IUserDAO;

@WebServlet(urlPatterns ="/admin-user")
public class UserController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserDAO userDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userIdStr = req.getParameter("userIdd");
        String action = req.getParameter("action");

        if (userIdStr != null) {
            try {
                int userId = Integer.parseInt(userIdStr);

                if ("delete".equals(action)) {
                    userDAO.deleteUser(userId);
                    resp.sendRedirect("admin-user");
                    return;
                } 
            } catch (NumberFormatException e) {
                req.setAttribute("error", "ID người dùng không hợp lệ.");
            }
        } else {
            req.setAttribute("error", "Thiếu ID người dùng.");
        }

		
		req.setAttribute("UserList", userDAO.findAllUser());
		req.getRequestDispatcher("views/admin/user.jsp").forward(req, resp);
	}
}
