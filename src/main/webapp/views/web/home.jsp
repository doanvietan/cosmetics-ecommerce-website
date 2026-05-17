<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<%@include file="/common/web/header.jsp"%>
	<!--slider section start-->
        <div class="hero-section section position-relative">
            <div class="tf-element-carousel slider-nav" data-slick-options='{
                "slidesToShow": 1,
                "slidesToScroll": 1,
                "infinite": true,
                "arrows": true,
                "dots": true
            }' data-slick-responsive='[
                {"breakpoint":768, "settings": {
                "slidesToShow": 1
                }},
                {"breakpoint":575, "settings": {
                "slidesToShow": 1,
                "arrows": false,
                "autoplay": true
                }}
            ]'>
                <!--Hero Item start-->
                <div class="hero-item bg-image" data-bg="${pageContext.request.contextPath}/template/web/images/hero/hero-2.jpg">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <!--Hero Content start-->
                                <div class="hero-content-2 color-2">
                                    <h2>view our</h2>
                                    <h1>Women's hair</h1>
                                    <h3>Products now</h3>
                                    <a href="shop">shop now</a>
                                </div>
                                <!--Hero Content end-->
                            </div>
                        </div>
                    </div>
                </div>
                <!--Hero Item end-->

                <!--Hero Item start-->
                <div class="hero-item bg-image" data-bg="${pageContext.request.contextPath}/template/web/images/hero/hero-9.jpg">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <!--Hero Content start-->
                                <div class="hero-content-2 color-2">
                                    <h2>view our</h2>
                                    <h1>Women's hair</h1>
                                    <h3>Products now</h3>
                                    <a href="shop.html">shop now</a>
                                </div>
                                <!--Hero Content end-->
                            </div>
                        </div>
                    </div>
                </div>
                <!--Hero Item end-->
            </div>
        </div>
        <!--slider section end-->

        <!-- Feature Section Start -->
        <div class="feature-section section pt-100 pt-md-75 pt-sm-60 pt-xs-50">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <!-- Single Faeture Start -->
                        <div class="single-feature feature-style-2 mb-30">
                            <div class="icon">
                                <i class="fa-truck fa"></i>
                            </div>
                            <div class="content">
                                <h2>Free shipping worldwide</h2>
                                <p>On order over $200</p>
                            </div>
                        </div>
                        <!-- Single Faeture End -->
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <!-- Single Faeture Start -->
                        <div class="single-feature feature-style-2 mb-30">
                            <div class="icon">
                                <i class="fa fa-undo"></i>
                            </div>
                            <div class="content">
                                <h2>30 days free return</h2>
                                <p>Money back guarantee</p>
                            </div>
                        </div>
                        <!-- Single Faeture End -->
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <!-- Single Faeture Start -->
                        <div class="single-feature feature-style-2 mb-30 br-0">
                            <div class="icon">
                                <i class="fa fa-thumbs-o-up"></i>
                            </div>
                            <div class="content">
                                <h2>Member safe shopping</h2>
                                <p>Safe shopping guarantee</p>
                            </div>
                        </div>
                        <!-- Single Faeture End -->
                    </div>
                </div>
            </div>
        </div>
        <!-- Feature Section End -->

        <!--Product section start-->
        <div class="product-section section pt-70 pt-lg-45 pt-md-40 pt-sm-30 pt-xs-15">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="product-tab-menu mb-40 mb-xs-20">
                            <ul class="nav">
                                <li><a class="active" data-toggle="tab" href="#products"> New Products</a></li>
                                <li><a data-toggle="tab" href="#onsale">Bets Seller</a></li>
                                <li><a data-toggle="tab" href="#featureproducts">Onsale</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="tab-content">
                            <div class="tab-pane fade show active" id="products">
                 
                                    <div class="row tf-element-carousel" data-slick-options='{
                                "slidesToShow": 4,
                                "slidesToScroll": 1,
                                "infinite": true,
                                "rows": 2,
                                "arrows": true,
                                "prevArrow": {"buttonClass": "slick-btn slick-prev", "iconClass": "fa fa-angle-left" },
                                "nextArrow": {"buttonClass": "slick-btn slick-next", "iconClass": "fa fa-angle-right" }
                                }' data-slick-responsive='[
                                {"breakpoint":1199, "settings": {
                                "slidesToShow": 3
                                }},
                                {"breakpoint":992, "settings": {
                                "slidesToShow": 2
                                }},
                                {"breakpoint":768, "settings": {
                                "slidesToShow": 2,
                                "arrows": false,
                                "autoplay": true
                                }},
                                {"breakpoint":576, "settings": {
                                "slidesToShow": 1,
                                "arrows": false,
                                "autoplay": true
                                }}
                                ]'>
                                        <c:forEach var="product" items="${Product}">
                                            <div class="col-12">
                                                <!-- Single Product Start -->
                                                <div class="single-product mb-30">
                                                    <div class="product-img">
                                                        <a href="single-product?productId=${product.productId}">
                                                            <img src="${pageContext.request.contextPath}/template/web/images/products/${product.productImage}" alt="${product.productName}">
                                                        </a>
                                                        <span class="descount-sticker">-10%</span>
                                                        <span class="sticker">New</span>
                                                        <div class="product-action d-flex justify-content-between">
                                                            <form action="home" method="POST">
                                                                <input type="hidden" name="productId" value="${product.productId}">
                                                                <button type="submit" class="product-btn" style="background-color: #333333; border: none; ">Add to Cart</button>
                                                            </form>
                                                            <ul class="d-flex">
                                                                <li><a href="#quick-view-modal-container" data-toggle="modal" title="Quick View"><i class="fa fa-eye"></i></a></li>
                                                                <li><a href="#"><i class="fa fa-heart-o"></i></a></li>
                                                                <li><a href="#"><i class="fa fa-exchange"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="product-content">
                                                        <h3><a href="single-product.php">${product.productName}</a></h3>
                                                        <div class="ratting">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                        </div>
                                                        <h4 class="price"><span class="new">€${product.productPrice}</span>
                                                        <span class="old">€</span></h4>
                                                    </div>
                                                </div>
                                                <!-- Single Product End -->
                                            </div>
                                        </c:forEach>
                                    </div>                  
                            </div>
                            <div class="tab-pane fade" id="onsale">
                                <div class="row tf-element-carousel" data-slick-options='{
                                "slidesToShow": 4,
                                "slidesToScroll": 1,
                                "infinite": true,
                                "rows": 2,
                                "arrows": true,
                                "prevArrow": {"buttonClass": "slick-btn slick-prev", "iconClass": "fa fa-angle-left" },
                                "nextArrow": {"buttonClass": "slick-btn slick-next", "iconClass": "fa fa-angle-right" }
                                }' data-slick-responsive='[
                                {"breakpoint":1199, "settings": {
                                "slidesToShow": 3
                                }},
                                {"breakpoint":992, "settings": {
                                "slidesToShow": 2
                                }},
                                {"breakpoint":768, "settings": {
                                "slidesToShow": 2,
                                "arrows": false,
                                "autoplay": true
                                }},
                                {"breakpoint":576, "settings": {
                                "slidesToShow": 1,
                                "arrows": false,
                                "autoplay": true
                                }}
                                ]'>
                                        <c:forEach var="product" items="${Product}">
                                            <div class="col-12">
                                                <!-- Single Product Start -->
                                                <div class="single-product mb-30">
                                                    <div class="product-img">
                                                        <a href="">
                                                            <img src="${pageContext.request.contextPath}/template/web/images/products/${product.productImage}" alt="">
                                                        </a>
                                                        <span class="descount-sticker">-10%</span>
                                                        <span class="sticker">New</span>
                                                        <div class="product-action d-flex justify-content-between">
                                                            <form action="cart.php" method="POST">
                                                                <input type="hidden" name="${product.productId}" value="${product.productId}">
                                                                <button type="submit" class="product-btn" style="background-color: #333333; border: none; ">Add to Cart</button>
                                                            </form>
                                                            <ul class="d-flex">
                                                                <li><a href="#quick-view-modal-container" data-toggle="modal" title="Quick View"><i class="fa fa-eye"></i></a></li>
                                                                <li><a href="#"><i class="fa fa-heart-o"></i></a></li>
                                                                <li><a href="#"><i class="fa fa-exchange"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="product-content">
                                                        <h3><a href="single-product.php">${product.productName}</a></h3>
                                                        <div class="ratting">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                        </div>
                                                        <h4 class="price"><span class="new">€${product.productPrice}</span>
                                                        <span class="old">€</span></h4>
                                                    </div>
                                                </div>
                                                <!-- Single Product End -->
                                            </div>
                                        </c:forEach>
                                    </div>         
                            </div>
                            <div class="tab-pane fade" id="featureproducts">
                                <div class="row tf-element-carousel" data-slick-options='{
                                "slidesToShow": 4,
                                "slidesToScroll": 1,
                                "infinite": true,
                                "rows": 2,
                                "arrows": true,
                                "prevArrow": {"buttonClass": "slick-btn slick-prev", "iconClass": "fa fa-angle-left" },
                                "nextArrow": {"buttonClass": "slick-btn slick-next", "iconClass": "fa fa-angle-right" }
                                }' data-slick-responsive='[
                                {"breakpoint":1199, "settings": {
                                "slidesToShow": 3
                                }},
                                {"breakpoint":992, "settings": {
                                "slidesToShow": 2
                                }},
                                {"breakpoint":768, "settings": {
                                "slidesToShow": 2,
                                "arrows": false,
                                "autoplay": true
                                }},
                                {"breakpoint":576, "settings": {
                                "slidesToShow": 1,
                                "arrows": false,
                                "autoplay": true
                                }}
                                ]'>
                                        <c:forEach var="product" items="${Product}">
                                            <div class="col-12">
                                                <!-- Single Product Start -->
                                                <div class="single-product mb-30">
                                                    <div class="product-img">
                                                        <a href="">
                                                            <img src="${pageContext.request.contextPath}/template/web/images/products/${product.productImage}" alt="">
                                                        </a>
                                                        <span class="descount-sticker">-10%</span>
                                                        <span class="sticker">New</span>
                                                        <div class="product-action d-flex justify-content-between">
                                                            <form action="cart.php" method="POST">
                                                                <input type="hidden" name="${product.productId}" value="${product.productId}">
                                                                <button type="submit" class="product-btn" style="background-color: #333333; border: none; ">Add to Cart</button>
                                                            </form>
                                                            <ul class="d-flex">
                                                                <li><a href="#quick-view-modal-container" data-toggle="modal" title="Quick View"><i class="fa fa-eye"></i></a></li>
                                                                <li><a href="#"><i class="fa fa-heart-o"></i></a></li>
                                                                <li><a href="#"><i class="fa fa-exchange"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="product-content">
                                                        <h3><a href="single-product.php">${product.productName}</a></h3>
                                                        <div class="ratting">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                        </div>
                                                        <h4 class="price"><span class="new">€${product.productPrice}</span>
                                                        <span class="old">€</span></h4>
                                                    </div>
                                                </div>
                                                <!-- Single Product End -->
                                            </div>
                                        </c:forEach>
                                    </div>         
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
	<%@include file="/common/web/footer.jsp"%>
</body>
</html>