package com.javaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import com.javaweb.dao.ICartDAO;
import com.javaweb.dao.IProductDAO;
import com.javaweb.dao.IReviewDAO;
import com.javaweb.model.CartModel;
import com.javaweb.model.ProductModel;
import com.javaweb.model.ReviewModel;

@WebServlet(urlPatterns = { "/single-product" })
public class SingleProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IProductDAO productDAO;
	@Inject
	private ICartDAO cartDAO;
	@Inject
	private IReviewDAO reviewDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		ProductModel product = productDAO.productFindById(productId);
		List<ReviewModel> reviews = reviewDAO.findByProductId(productId);
		
		double averageRating = 0;
		int roundedRating = 0;

		if (reviews != null && !reviews.isEmpty()) {
		    int sum = 0;
		    for (ReviewModel review : reviews) {
		        sum += review.getRating();
		    }
		    averageRating = (double) sum / reviews.size();
		    roundedRating = (int) Math.round(averageRating);
		}

		req.setAttribute("roundedRating", roundedRating);
		req.setAttribute("reviewCount", reviews.size());


		req.setAttribute("productId", productId);
		req.setAttribute("product", product);
		req.setAttribute("reviews", reviews);
		req.getRequestDispatcher("/views/web/singleproduct.jsp").forward(req, resp); // Forward đến JSP
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
		try {
			int productId = Integer.parseInt(req.getParameter("productId"));
			String actionType = req.getParameter("actionType");
			HttpSession session = req.getSession();
			Integer userId = (Integer) session.getAttribute("userId");


			if (userId == null) {
				resp.sendRedirect("login");
				return;
			}
			if ("addReview".equals(actionType)) {
				int rating = Integer.parseInt(req.getParameter("rating"));
				String comment = req.getParameter("comment");


				ReviewModel review = new ReviewModel();
				review.setProductId(productId);
				review.setUserId(userId);
				review.setRating(rating);
				review.setComment(comment);

				reviewDAO.insertReview(review);
				resp.sendRedirect("single-product?productId=" + productId);
			} else if("addToCart".equals(actionType)){
				addToCart(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			int productId = Integer.parseInt(req.getParameter("productId"));
			HttpSession session = req.getSession();
			Integer userId = (Integer) session.getAttribute("userId");

			if (userId != null) {
				CartModel cartModel = new CartModel(productId, userId, quantity);
				cartDAO.cartInsert(cartModel);
				resp.sendRedirect("cart");
			} else {
				resp.sendRedirect("login");
			}
		} catch (NumberFormatException e) {
			resp.sendRedirect("home?error=invalid_product_id");
		}
	}
}
