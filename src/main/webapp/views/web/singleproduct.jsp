<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Single-Product</title>
</head>
<style>

</style>
<body>
<body>
	<%@include file="/common/web/header.jsp"%>

	<div class="page-banner-section section bg-gray">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="page-banner text-center">
						<h1 style="margin: 0 !important;">Sản phẩm</h1>
						<ul class="page-breadcrumb">
							<li><a href="index.html">Home</a></li>
							<li>Sản phẩm</li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- Single Product Section Start -->
	<!-- Single Product Section Start -->
	<div
		class="single-product-section section pt-30 pt-lg-80 pt-md-70 pt-sm-60 pt-xs-50 pb-100 pb-lg-80 pb-md-70 pb-sm-30 pb-xs-20">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<!-- Product Details Left -->
					<!--Product Details Left -->
					<img
						src="${pageContext.request.contextPath}/template/web/images/products/${product.productImage}"
						alt="${product.productName}">
				</div>
				<div class="col-md-7">
					<!--Product Details Content Start-->
					<div class="product-details-content">
						<h2>${product.productName}</h2>
						<div class="single-product-reviews">
    <!-- Hiển thị sao đầy -->
    <c:forEach begin="1" end="${roundedRating}">
        <i class="fa fa-star"></i>
    </c:forEach>

    <!-- Hiển thị sao rỗng -->
    <c:forEach begin="1" end="${5 - roundedRating}">
        <i class="fa fa-star-o"></i>
    </c:forEach>

</div>
						<div class="single-product-price">
							<span class="price new-price">${product.productPrice}</span>
						</div>
						<div class="product-description">
							<p>${product.productDescription}</p>
						</div>
						<div class="single-product-quantity">
							<form class="add-quantity" action="single-product" method="post">
							 <input type="hidden" name="actionType" value="addToCart">
								<div class="product-quantity">

									<input type="hidden" name="productId" value="${productId}">

									<input name="quantity" value="1" type="number">
								</div>
								<div class="add-to-link">
									<button class="product-add-btn" data-text="add to cart">Add
										to Cart</button>
								</div>
							</form>
						</div>
						<div class="wishlist-compare-btn">
							<a href="#" class="wishlist-btn">Add to Wishlist</a> <a href="#"
								class="add-compare">Compare</a>
						</div>
						<div class="product-meta">
							<span class="posted-in"> Categories: <a href="#">Accessories</a>,
								<a href="#">Electronics</a>
							</span>
						</div>
					</div>
					<!--Product Details Content End-->
				</div>
			</div>
		</div>
	</div>
	<!--Product Description Review Section Start-->
	<div class="product-description-review-section section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-review-tab">

						<!--Review And Description Tab Content Start-->
						<div class="tab-content product-review-content-tab"
							id="myTabContent-4">

							<div class="tab-pane fade active show" id="reviews">
								<div class="review-page-comment">
									<div class="customer-review mt-5">
    <h4 class="mb-4">Đánh giá sản phẩm</h4>
    <ul class="list-unstyled">
        <c:forEach var="review" items="${reviews}">
            <li class="media mb-4 pb-3 border-bottom">
                <img src="${pageContext.request.contextPath}/template/web/images/user.jpg"
                     class="mr-3 rounded-circle" alt="User" width="60" height="60">
                <div class="media-body">
                    <h5 class="mt-0 mb-1">
                        <strong>${review.userName}</strong>
                        <small class="text-muted ml-2">
                            <fmt:formatDate value="${review.reviewDate}" pattern="dd/MM/yyyy" />
                        </small>
                    </h5>
                    <div class="rating mb-2">
                        <c:forEach var="i" begin="1" end="5">
                            <i class="fa 
                                <c:choose>
                                    <c:when test='${i <= review.rating}'>fa-star text-warning</c:when>
                                    <c:otherwise>fa-star-o text-secondary</c:otherwise>
                                </c:choose>"></i>
                        </c:forEach>
                    </div>
                    <p>${review.comment}</p>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>


									<div class="review-form-wrapper">
										<div class="review-form">
											<span class="comment-reply-title">Add a review </span>
											<div class="container mt-5">
												<div class="card">
													<div class="card-header bg-primary text-white">Thêm
														đánh giá của bạn</div>
													<div class="card-body">
														<form action="single-product" method="post">
														    <input type="hidden" name="actionType" value="addReview">
															<input type="hidden" name="productId"
																value="${productId}">

															<div class="form-group">
																<label for="rating">Đánh giá</label> <select
																	class="form-control" name="rating" id="rating" required>
																	<option value="5">★★★★★</option>
																	<option value="4">★★★★☆</option>
																	<option value="3">★★★☆☆</option>
																	<option value="2">★★☆☆☆</option>
																	<option value="1">★☆☆☆☆</option>
																</select>
															</div>

															<div class="form-group">
																<label for="comment">Bình luận</label>
																<textarea class="form-control" name="comment"
																	id="comment" rows="4" required></textarea>
															</div>

															<button type="submit" class="btn">Gửi
																đánh giá</button>
														</form>
													</div>
												</div>
											</div>


										</div>
									</div>
								</div>
							</div>
						</div>
						<!--Review And Description Tab Content End-->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Product Description Review Section Start-->



	<%@include file="/common/web/footer.jsp"%>
</body>
</body>
</html>