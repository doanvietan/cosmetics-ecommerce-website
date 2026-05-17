package com.javaweb.controller.admin;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.javaweb.dao.ICategoryDAO;

@WebServlet(urlPatterns = "/admin-category")
public class CategoryController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("Category", categoryDAO.findAllCategory());
        req.getRequestDispatcher("views/admin/category.jsp").forward(req, resp);
    }
}
