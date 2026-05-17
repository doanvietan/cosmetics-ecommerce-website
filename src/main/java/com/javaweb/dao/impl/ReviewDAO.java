package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IReviewDAO;
import com.javaweb.model.ReviewModel;

public class ReviewDAO implements IReviewDAO {

	@Override
	public List<ReviewModel> findByProductId(int productId) {
	    List<ReviewModel> reviews = new ArrayList<>();
	    String sql = "SELECT r.*, u.user_name AS user_name " +
	             "FROM reviews r " +
	             "JOIN users u ON r.user_id = u.user_id " +
	             "WHERE r.product_id = ? ";

	    Connection conn = DatabaseDAO.getConnection();
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, productId);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            ReviewModel review = new ReviewModel();
	            review.setReviewId(rs.getInt("review_id"));
	            review.setProductId(rs.getInt("product_id"));
	            review.setUserId(rs.getInt("user_id"));
	            review.setRating(rs.getInt("rating"));
	            review.setComment(rs.getString("comment"));
	            review.setReviewDate(rs.getTimestamp("review_date"));
	            review.setUserName(rs.getString("user_name")); // dòng mới
	            reviews.add(review);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return reviews;
	}
	@Override
	public void insertReview(ReviewModel review ) {
	    String sql = "INSERT INTO reviews (product_id, user_id, rating, comment, review_date) VALUES (?, ?, ?, ?, NOW())";
	    try (Connection conn = DatabaseDAO.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, review.getProductId());
	        ps.setInt(2, review.getUserId());
	        ps.setInt(3, review.getRating());
	        ps.setString(4, review.getComment());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
