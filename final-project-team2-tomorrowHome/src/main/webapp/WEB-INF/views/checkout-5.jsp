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
    <link rel="stylesheet" href="css/shop/order.css">

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

    <!-- Breadcumb Area -->
    <div class="breadcumb_area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <h5>Checkout</h5>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index">Home</a></li>
                        <li class="breadcrumb-item active">Checkout</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcumb Area -->

    <!-- Checkout Step Area -->
    <div class="checkout_steps_area">
        <a class="complated"><i class="icofont-check-circled"></i> Orderer</a>
        <a class="complated"><i class="icofont-check-circled"></i> Reciever</a>
        <a class="complated"><i class="icofont-check-circled"></i> Payment</a>
        <a class="active"><i class="icofont-check-circled"></i> Confirm</a>
        <a><i class="icofont-check-circled"></i> Complate</a>
    </div>
    <!-- Checkout Step Area -->

    <!-- Checkout Area -->
    <div class="checkout_area section_padding_100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="checkout_details_area clearfix">
                        <h5 class="mb-30">Confirm Your Order</h5>

                        <div class="cart-table">
                            <div class="table-responsive">
                                <table class="table table-bordered mb-30">
                                    <thead>
                                        <tr>
                                            <th scope="col">Image</th>
                                            <th scope="col">Product</th>
                                            <th scope="col">Unit Price</th>
                                            <th scope="col">Quantity</th>
                                            <th scope="col">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <!-- order item start -->
                                    <c:set var="tot_price" value="0" />
                                    <c:forEach var="o_cart" items="${cartItemList}">
                                    <c:set var="tot_price" value="${tot_price + o_cart.product.p_price * o_cart.c_qty}" />
                                        <tr>
                                            <td>
                                                <img src="img/p_img/${o_cart.product.imageList[0].im_name}" alt="Product">
                                            </td>
                                            <td>
                                                <a href="#">${o_cart.product.p_name}</a>
                                            </td>
                                            <td>&#8361;<s:eval expression="new java.text.DecimalFormat('#,###').format(o_cart.product.p_price)"/></td>
                                            <td>
                                                <div class="quantity">
                                                    <input type="number" readonly class="qty-text" id="qty2" step="1" min="1" max="99" name="quantity" value="${o_cart.c_qty}" readonly>
                                                </div>
                                            </td>
                                            <c:set var="item_tot_price" value="${o_cart.product.p_price * o_cart.c_qty}"></c:set>
                                            <td>&#8361;<s:eval expression="new java.text.DecimalFormat('#,###').format(item_tot_price)"/></td>
                                        </tr>
                                    </c:forEach> 
                                    <!-- order item end -->
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-lg-7 ml-auto">
                    <div class="cart-total-area">
                        <h5 class="mb-3">Cart Totals</h5>
                        <div class="table-responsive">
                            <table class="table mb-0">
                                <tbody>
                                    <tr>
                                        <td>Sub Total</td>
                                        <td>&#8361;<s:eval expression="new java.text.DecimalFormat('#,##0').format(tot_price)"/></td>
                                    </tr>
                                    <tr>
                                        <td>Shipping</td>
                                        <td>
	                                       	<c:if test="${tot_price < 50000}">
	                                        	&#8361;<s:eval expression="new java.text.DecimalFormat('#,##0').format(2500)"/>
	                                        	<c:set var="shipping_price" value="2500" />
	                                        </c:if>
	                                        <c:if test="${tot_price >= 50000}">
	                                        	&#8361;0
	                                        	<c:set var="shipping_price" value="0" />
	                                        </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Total</td>
                                        <c:set var="all_total" value="${tot_price + shipping_price}" />
                                        <td id="cart_total">&#8361;<s:eval expression="new java.text.DecimalFormat('#,##0').format(all_total)"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="checkout_pagination d-flex justify-content-end mt-3">
                            <a href="" class="btn btn-primary mt-2 ml-2 d-none d-sm-inline-block order_back" id="back_confirm">Go Back</a>
                            <a href="" class="btn btn-primary mt-2 ml-2" id="order_create_btn" >Order</a>
                        </div>     
                        <form id="order_create_form" method="post">
                        	<input type="hidden" name="total_price" value="${tot_price + shipping_price}">
                        </form> 
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Checkout Area End -->

    <!-- Footer Area -->
 	<jsp:include page="common/include_common_bottom.jsp"/>
    <!-- Footer Area -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
	<jsp:include page="common/include_common_script.jsp"/>
	<script src="js/shop/order.js"></script>

</body>

</html>