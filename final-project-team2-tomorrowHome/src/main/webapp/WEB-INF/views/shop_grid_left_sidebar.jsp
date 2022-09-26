<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- include_common_top -->
	<jsp:include page="common/include_common_top.jsp"/>
    <!-- include_common_top -->
    <link rel="stylesheet" href="css/shop/product.css">

</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div class="spinner-grow" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>

    <!-- Header Area -->
    <jsp:include page="common/include_common_header.jsp"/>
    <!-- Header Area End -->
    
    <!-- Quick View Modal Area -->
    <jsp:include page="common/include_product_quickview_modal.jsp"/>
    <!-- Quick View Modal Area end -->

    <!-- Breadcumb Area -->
    <div class="breadcumb_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <h5>Shop Grid</h5>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                        <li class="breadcrumb-item active">Shop Grid</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcumb Area -->
    
    <section class="shop_grid_area section_padding_100">
        <div class="container">
            <div class="row">
                <div class="col-12 col-sm-5 col-md-4 col-lg-3">
                    <div class="shop_sidebar_area">

						<!-- Product Categories -->
						
                        <!-- Single Widget -->
                        <div class="widget catagory mb-30">
                            <h6 class="widget-title"></h6>
                            <div class="widget-desc">
                                <!-- Single Checkbox  -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="button" class="custom-control-input" id="all_reset_btn">
                                    <label class="custom-control-label" for="all_reset_btn">All Product<span class="text-muted"></span></label>
                                </div>
                             </div>
                         </div>

                        <!-- Single Widget -->
                        <div class="widget catagory mb-30">
                            <h6 class="widget-title">Product Categories</h6>
                            <div class="widget-desc p_category">
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck1" cg_no="1">
                                    <label class="custom-control-label" for="customCheck1">Plant pot <span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck2" cg_no="2">
                                    <label class="custom-control-label" for="customCheck2">Light <span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck3" cg_no="3">
                                    <label class="custom-control-label" for="customCheck3">Props <span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck4" cg_no="4">
                                    <label class="custom-control-label" for="customCheck4">Clock <span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center">
                                    <input type="checkbox" class="custom-control-input" id="customCheck5" cg_no="5">
                                    <label class="custom-control-label" for="customCheck5">Etc <span class="text-muted"></span></label>
                                </div>
                            </div>
                        </div>
                        
                        <!-- Filter by Price -->

                        <!-- Single Widget -->
                        <div class="widget price mb-30">
                            <h6 class="widget-title">Filter by Price</h6>
                            <div class="widget-desc p_price">
                                <div class="slider-range">
                                    <div data-min="0" data-max="100000" data-unit="&#8361;" class="slider-range-price ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all" data-value-min="0" data-value-max="100000" data-label-result="Price:">
                                        <div class="ui-slider-range ui-widget-header ui-corner-all"></div>
                                        <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                                        <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                                    </div>
                                    <div class="range-price">Price: &#8361;0 - &#8361;1000000</div>
                                </div>
                            </div>
                        </div>
                        
                        <!-- Filter by Color -->
                        
                        <!-- Single Widget -->
                        <div class="widget color mb-30">
                            <h6 class="widget-title">Filter by Color</h6>
                            <div class="widget-desc p_color">
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck6" >
                                    <label class="custom-control-label black" for="customCheck6">Black<span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck7">
                                    <label class="custom-control-label pink" for="customCheck7">Pink<span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck8">
                                    <label class="custom-control-label red" for="customCheck8">Red<span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck9" >
                                    <label class="custom-control-label purple" for="customCheck9">Purple<span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center">
                                    <input type="checkbox" class="custom-control-input" id="customCheck10">
                                    <label class="custom-control-label orange" for="customCheck10">Orange<span class="text-muted"></span></label>
                                </div>
                            </div>
                        </div>

						<!-- Filter by brands -->

                        <!-- Single Widget -->
                        <div class="widget brands mb-30">
                            <h6 class="widget-title">Filter by brands</h6>
                            <div class="widget-desc p_brand">
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck11">
                                    <label class="custom-control-label" for="customCheck11">peopleland <span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck12">
                                    <label class="custom-control-label" for="customCheck12">bestlight <span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck13">
                                    <label class="custom-control-label" for="customCheck13">plantree <span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center mb-2">
                                    <input type="checkbox" class="custom-control-input" id="customCheck14">
                                    <label class="custom-control-label" for="customCheck14">muas <span class="text-muted"></span></label>
                                </div>
                                <!-- Single Checkbox -->
                                <div class="custom-control custom-checkbox d-flex align-items-center">
                                    <input type="checkbox" class="custom-control-input" id="customCheck15">
                                    <label class="custom-control-label" for="customCheck15">mjk <span class="text-muted"></span></label>
                                </div>
                            </div>
                        </div>

                        <!-- Average Rating -->
                        
                        <!-- Single Widget -->
                        <div class="widget rating mb-30">
                            <h6 class="widget-title">Average Rating</h6>
                            <div class="widget-desc p_score">
                                <ul>
                                	<div class="custom-control custom-checkbox d-flex align-items-center mb-2"">
                                		<input type="checkbox" class="custom-control-input" id="customCheck16" score="5">
                                		<label class="custom-control-label" for="customCheck16">
                                			<li><a href=""><i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <span class="text-muted"></span></a></li>
                                		</label>
                                    </div>
                                	<div class="custom-control custom-checkbox d-flex align-items-center mb-2"">
                                		<input type="checkbox" class="custom-control-input" id="customCheck17" score="4">
                                		<label class="custom-control-label" for="customCheck17">
                                    		<li><a href=""><i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <span class="text-muted"></span></a></li>
                                		</label>
                                    </div>
                                	<div class="custom-control custom-checkbox d-flex align-items-center mb-2"">
                                		<input type="checkbox" class="custom-control-input" id="customCheck18" score="3">
                                		<label class="custom-control-label" for="customCheck18">
                                    		<li><a href=""><i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <span class="text-muted"></span></a></li>
                                		</label>
                                    </div>
                                	<div class="custom-control custom-checkbox d-flex align-items-center mb-2"">
                                		<input type="checkbox" class="custom-control-input" id="customCheck19" score="2">
                                		<label class="custom-control-label" for="customCheck19">
                                    		<li><a href=""><i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <span class="text-muted"></span></a></li>
                                		</label>
                                    </div>
                                	<div class="custom-control custom-checkbox d-flex align-items-center"">
                                		<input type="checkbox" class="custom-control-input" id="customCheck20" score="1">
                                		<label class="custom-control-label" for="customCheck20">
                                    		<li><a href=""><i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <i class="fa fa-star-o" aria-hidden="true"></i> <span class="text-muted"></span></a></li>
                                		</label>
                                    </div>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-sm-7 col-md-8 col-lg-9">
                    <!-- Shop Top Sidebar -->
                    <div class="shop_top_sidebar_area d-flex flex-wrap align-items-center justify-content-between">
                        <div class="view_area d-flex">
                            <div class="grid_view">
                                <a href="#" data-toggle="tooltip" data-placement="top" title="Grid View"><i class="icofont-layout"></i></a>
                            </div>
<!--                             <div class="list_view ml-3">
                                <a href="shop-list-left-sidebar.html" data-toggle="tooltip" data-placement="top" title="List View"><i class="icofont-listine-dots"></i></a>
                            </div> -->
                        </div>
                        <select class="small right" id="sortBy">
                            <option value="">sort_by</option>
                            <option value="price_lh">low_price</option>
                            <option value="price_hl">high_price</option>
                            <option value="score">review_score</option>
                        </select>
                    </div>

                    <div class="shop_grid_product_area">
                        <div class="row justify-content-center">

                            <!-- Single Product start -->
                            
                            <c:forEach var="product" items="${productList.itemList}">
	                            <div class="col-9 col-sm-12 col-md-6 col-lg-4">
	                                <div class="single-product-area mb-30">
	                                    <div class="product_image">
	                                        <!-- Product Image -->
	                                        <img class="normal_img" src="img/p_img/${product.imageList[0].im_name}" alt="">
	                                        <img class="hover_img" src="img/p_img/${product.imageList[1].im_name}" alt="">
		
	                                        <!-- Product Badge -->
	                                        <div class="product_badge">
	                                            <span>${product.p_concept}</span>
	                                        </div>
	
	                                        <!-- Wishlist -->
	                                        <div class="product_wishlist">
	                                            <a href="" class="list_to_wish_btn" p_no="${product.p_no}"><i class="icofont-heart"></i></a>
	                                        </div>
	
	                                    </div>
	
	                                    <!-- Product Description -->
	                                    <div class="product_description">
	                                        <!-- Add to cart -->
	                                        <div class="product_add_to_cart">
	                                            <a href="#" class="list_add_to_cart_btn" p_no="${product.p_no}"><i class="icofont-shopping-cart"></i> Add to Cart</a>
	                                        </div>
	
	                                        <!-- Quick View -->
	                                        <div class="product_quick_view">
	                                            <a href="#" data-toggle="modal" data-target="#quickview" p_no="${product.p_no}"><i class="icofont-eye-alt"></i> Quick View</a>
	                                        </div>
	
	                                        <p class="brand_name">${product.p_brand}</p>
	                                        <a href="product_detail?p_no=${product.p_no}" p_no="${product.p_no}">${product.p_name}</a>
	                                        <h6 class="product-price">&#8361;<s:eval expression="new java.text.DecimalFormat('#,###').format(product.p_price)"/><span></span></h6>
	                                    	
	                                    </div>
	                                </div>
	                            </div>
							</c:forEach>
							
                            <!-- Single Product end -->
                           
                        </div>
                    </div>

                    <!-- Shop Pagination Area -->
                    
                    <div class="shop_pagination_area mt-30">
                        <nav aria-label="Page navigation">
                            <ul class="pagination pagination-sm justify-content-center">
                            	<c:if test="${productList.pageMaker.prevPage > 0}">  
	            					<li class="page-item">
	                                    <button class="page-link" onclick="changeProductList(${data.pageMaker.prevPage});"><i class="fa fa-angle-left" aria-hidden="true"></i></button>
	                               	 </li>
                                </c:if>
                                <c:forEach var="no" begin="${productList.pageMaker.blockBegin}" end="${productList.pageMaker.blockEnd}">
									<c:if test="${productList.pageMaker.curPage == no}">
										<li class="page-item active"><button class="page-link" href="#">${no}</button></li>
									</c:if>
									<c:if test="${productList.pageMaker.curPage != no}">
										<li class="page-item"><button class="page-link page" onclick="changeProductList(${no})">${no}</button></li>
									</c:if>
                                </c:forEach>
                                <c:if test="${productList.pageMaker.curPage < productList.pageMaker.totPage}">  
	                                <li class="page-item">
				                        <button class="page-link" onclick="changeProductList(${productList.pageMaker.nextPage});"><i class="fa fa-angle-right" aria-hidden="true"></i></button>
			                    	 </li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>

                </div>
            </div>
        </div>
    </section>

    <!-- Footer Area -->
 	<jsp:include page="common/include_common_bottom.jsp"/>
    <!-- Footer Area -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
	<jsp:include page="common/include_common_script.jsp"/>
	<script src="js/shop/product.js"></script>
	<script type="text/javascript">

		
	</script>
</body>

</html>