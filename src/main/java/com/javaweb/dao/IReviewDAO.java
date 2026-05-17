package com.javaweb.dao;

import java.util.List;

import com.javaweb.model.ReviewModel;

public interface IReviewDAO {
	List<ReviewModel> findByProductId(int productId);

	void insertReview(ReviewModel review);}
