<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.lang.Math" %>    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">

  <head>
    <meta charset="utf-8">
    <title>Cart</title>
    <!-- SEO Meta Tags-->
    <meta name="description" content="Unishop - Universal E-Commerce Template">
    <meta name="keywords" content="shop, e-commerce, modern, flat style, responsive, online store, business, mobile, blog, bootstrap 4, html5, css3, jquery, js, gallery, slider, touch, creative, clean">
    <meta name="author" content="Rokaux">
    <!-- Mobile Specific Meta Tag-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- Favicon and Apple Icons-->
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link rel="icon" type="image/png" href="favicon.png">
    <link rel="apple-touch-icon" href="touch-icon-iphone.png">
    <link rel="apple-touch-icon" sizes="152x152" href="touch-icon-ipad.png">
    <link rel="apple-touch-icon" sizes="180x180" href="touch-icon-iphone-retina.png">
    <link rel="apple-touch-icon" sizes="167x167" href="touch-icon-ipad-retina.png">
    <!-- Vendor Styles including: Bootstrap, Font Icons, Plugins, etc.-->
    <link rel="stylesheet" media="screen" href="css/vendor.min.css">
    <!-- Main Template Styles-->
    <link id="mainStyles" rel="stylesheet" media="screen" href="css/styles.min.css">
    <!-- Modernizr-->
    <script src="js/modernizr.min.js"></script>
  </head>
  <!-- Body-->
  <body>
    <!-- Off-Canvas Category Menu-->
 	<!-- include_common_top.jsp start  -->
	<jsp:include page="include_common_top.jsp"/>
	<!-- include_common_top.jsp end  -->
	
    <!-- Off-Canvas Wrapper-->
    <div class="offcanvas-wrapper">
      <!-- Page Title-->
      <div class="page-title">
        <div class="container">
          <div class="column">
            <h1>Cart</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="index.html">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>Cart</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-1">
        <!-- Alert-->
        <div class="alert alert-info alert-dismissible  fade show text-center" style="margin-bottom: 30px;">
        <span class="alert-close" data-dismiss="alert"></span>
        <img class="d-inline align-center" src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iTGF5ZXJfMSIgeD0iMHB4IiB5PSIwcHgiIHZpZXdCb3g9IjAgMCA1MTIuMDAzIDUxMi4wMDMiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUxMi4wMDMgNTEyLjAwMzsiIHhtbDpzcGFjZT0icHJlc2VydmUiIHdpZHRoPSIxNnB4IiBoZWlnaHQ9IjE2cHgiPgo8Zz4KCTxnPgoJCTxnPgoJCQk8cGF0aCBkPSJNMjU2LjAwMSw2NGMtNzAuNTkyLDAtMTI4LDU3LjQwOC0xMjgsMTI4czU3LjQwOCwxMjgsMTI4LDEyOHMxMjgtNTcuNDA4LDEyOC0xMjhTMzI2LjU5Myw2NCwyNTYuMDAxLDY0eiAgICAgIE0yNTYuMDAxLDI5OC42NjdjLTU4LjgxNiwwLTEwNi42NjctNDcuODUxLTEwNi42NjctMTA2LjY2N1MxOTcuMTg1LDg1LjMzMywyNTYuMDAxLDg1LjMzM1MzNjIuNjY4LDEzMy4xODQsMzYyLjY2OCwxOTIgICAgIFMzMTQuODE3LDI5OC42NjcsMjU2LjAwMSwyOTguNjY3eiIgZmlsbD0iIzUwYzZlOSIvPgoJCQk8cGF0aCBkPSJNMzg1LjY0NCwzMzMuMjA1YzM4LjIyOS0zNS4xMzYsNjIuMzU3LTg1LjMzMyw2Mi4zNTctMTQxLjIwNWMwLTEwNS44NTYtODYuMTIzLTE5Mi0xOTItMTkycy0xOTIsODYuMTQ0LTE5MiwxOTIgICAgIGMwLDU1Ljg1MSwyNC4xMjgsMTA2LjA2OSw2Mi4zMzYsMTQxLjE4NEw2NC42ODQsNDk3LjZjLTEuNTM2LDQuMTE3LTAuNDA1LDguNzI1LDIuODM3LDExLjY2OSAgICAgYzIuMDI3LDEuNzkyLDQuNTY1LDIuNzMxLDcuMTQ3LDIuNzMxYzEuNjIxLDAsMy4yNDMtMC4zNjMsNC43NzktMS4xMDlsNzkuNzg3LTM5Ljg5M2w1OC44NTksMzkuMjMyICAgICBjMi42ODgsMS43OTIsNi4xMDEsMi4yNCw5LjE5NSwxLjI4YzMuMDkzLTEuMDAzLDUuNTY4LTMuMzQ5LDYuNjk5LTYuNGwyMy4yOTYtNjIuMTQ0bDIwLjU4Nyw2MS43MzkgICAgIGMxLjA2NywzLjE1NywzLjU0MSw1LjYzMiw2LjY3Nyw2LjcyYzMuMTM2LDEuMDY3LDYuNTkyLDAuNjQsOS4zNjUtMS4yMTZsNTguODU5LTM5LjIzMmw3OS43ODcsMzkuODkzICAgICBjMS41MzYsMC43NjgsMy4xNTcsMS4xMzEsNC43NzksMS4xMzFjMi41ODEsMCw1LjEyLTAuOTM5LDcuMTI1LTIuNzUyYzMuMjY0LTIuOTIzLDQuMzczLTcuNTUyLDIuODM3LTExLjY2OUwzODUuNjQ0LDMzMy4yMDV6ICAgICAgTTI0Ni4wMTcsNDEyLjI2N2wtMjcuMjg1LDcyLjc0N2wtNTIuODIxLTM1LjJjLTMuMi0yLjExMi03LjMxNy0yLjM4OS0xMC42ODgtMC42NjFMOTQuMTg4LDQ3OS42OGw0OS41NzktMTMyLjIyNCAgICAgYzI2Ljg1OSwxOS40MzUsNTguNzk1LDMyLjIxMyw5My41NDcsMzUuNjA1TDI0Ni43LDQxMS4yQzI0Ni40ODcsNDExLjU2MywyNDYuMTY3LDQxMS44NCwyNDYuMDE3LDQxMi4yNjd6IE0yNTYuMDAxLDM2Mi42NjcgICAgIEMxNjEuOSwzNjIuNjY3LDg1LjMzNSwyODYuMTAxLDg1LjMzNSwxOTJTMTYxLjksMjEuMzMzLDI1Ni4wMDEsMjEuMzMzUzQyNi42NjgsOTcuODk5LDQyNi42NjgsMTkyICAgICBTMzUwLjEwMywzNjIuNjY3LDI1Ni4wMDEsMzYyLjY2N3ogTTM1Ni43NTksNDQ5LjEzMWMtMy40MTMtMS43MjgtNy41MDktMS40NzItMTAuNjg4LDAuNjYxbC01Mi4zNzMsMzQuOTIzbC0zMy42NDMtMTAwLjkyOCAgICAgYzQwLjM0MS0wLjg1Myw3Ny41ODktMTQuMTg3LDEwOC4xNi0zNi4zMzFsNDkuNTc5LDEzMi4yMDNMMzU2Ljc1OSw0NDkuMTMxeiIgZmlsbD0iIzUwYzZlOSIvPgoJCTwvZz4KCTwvZz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K" width="18" height="18" alt="Medal icon">
        &nbsp;&nbsp;구매시 <strong>290</strong> 포인트 적립.</div>
        <!-- Shopping Cart-->
        <div class="table-responsive shopping-cart">
          <table class="table">
            <thead>
              <tr>
                <th>Product Name</th>
                <th class="text-center">Quantity</th>
                <th class="text-center">Subtotal</th>
                <th class="text-center">Discount</th>
                <th class="text-center"><a class="btn btn-sm btn-outline-danger btn-clear-cart" href="#">Clear Cart</a></th>
              </tr>
            </thead>
            <tbody>
             <!-- cart item start -->
             <c:set var="tot_price"  value="0"/>
			 <c:set var="tot_price"  value="${tot_price+0}"/>
             <c:forEach items="${cartItemList}" var="cartItem">
             <c:set var="tot_price"  value="${tot_price + cartItem.product.p_price * cartItem.cart_qty}"/>
              <tr>
                <td>
                  <div class="product-item"><a class="product-thumb" href="shop-single?p_no=${cartItem.product.p_no}"><img src="img/shop/cart/${cartItem.product.p_image}" alt="Product"></a>
                    <div class="product-info">
                      <h4 class="product-title"><a href="shop-single?p_no=${cartItem.product.p_image}">${cartItem.product.p_name }</a></h4><span><em>Size:</em> 10.5</span><span><em>Color:</em> Dark Blue</span>
                    </div>
                  </div>
                </td>
                <td class="text-center">
                  <div class="count-input">
                    <select class="form-control" cart-no="${cartItem.cart_no}">
					 <c:forEach begin="1" end="10" var="i"> 
					   <c:if test="${cartItem.cart_qty == i}">
					   	<option selected="selected">${i}</option>
					   </c:if>
					   <c:if test="${cartItem.cart_qty != i}">
					   	<option>${i}</option>
					   </c:if>
                     </c:forEach>
                    </select>
                  </div>
                </td>
                <td id="subtotal-${cartItem.cart_no}" class="text-center text-lg text-medium">&#8361;<s:eval expression="new java.text.DecimalFormat('#,##0').format(cartItem.product.p_price * cartItem.cart_qty)"/></td>
                <td class="text-center text-lg text-medium">&#8361;00.00</td>
                <td class="text-center">
                	<a class="remove-from-cart" href="#" data-toggle="tooltip" title="Remove item"  cart-no="${cartItem.cart_no}">
                		<i class="icon-cross" cart-no="${cartItem.cart_no}"></i>
                	</a></td>
              </tr>
              <!-- cart item end -->
              </c:forEach>
             
            </tbody>
          </table>
        </div>
        <div class="shopping-cart-footer">
          <div class="column">
            <form class="coupon-form" method="post">
              <input class="form-control form-control-sm" type="text" placeholder="Coupon code" required>
              <button class="btn btn-outline-primary btn-sm" type="submit">Apply Coupon</button>
            </form>
          </div>
          <div class="column text-lg">Subtotal: <span class="text-medium subtotal">&#8361;<s:eval expression="new java.text.DecimalFormat('#,##0').format(tot_price)"/></span></div>
        </div>
        <div class="shopping-cart-footer">
          <div class="column"><a class="btn btn-outline-secondary" href="shop-grid-ns"><i class="icon-arrow-left"></i>&nbsp;Back to Shopping</a></div>
          <div class="column">
          <!-- <a class="btn btn-primary" href="#" data-toast data-toast-type="success"  data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Your cart" data-toast-message="is updated successfully!">Update Cart</a> -->
          <c:if test="${empty cartItemList}">
          <a class="btn btn-success btn-cart-checkout" href="checkout-address.html" disabled >Checkout</a>
          </c:if>
          <c:if test="${!empty cartItemList}">
          <a class="btn btn-success btn-cart-checkout"" href="checkout-address.html" >Checkout</a>
          </c:if>
          </div>
        </div>
        <!-- Related Products Carousel-->
       
      	<!-- Related Products Carousel-->
        <!-- include_related_product_list.jsp start -->
        <jsp:include page="include_related_product_list.jsp"/>
        <!-- include_related_product_list.jsp end -->
       
        </div>
      </div>
      <!-- Site Footer-->
    <!-- include_common_top.jsp start-->
<jsp:include page="include_common_bottom.jsp"/>
<!-- include_common_top.jsp end  -->  
    <!-- JavaScript (jQuery) libraries, plugins and custom scripts-->
    <script src="js/vendor.min.js"></script>
    <script src="js/scripts.min.js"></script>
    
    <script src="js/custom.shop.js"></script>
    <script src="js/custom.cart.js"></script>
   
    
    <script type="text/javascript">
    	$(function(){
    		
    		/******** .btn-add-cart 버튼 이벤트처리************/
        	$('.btn-add-cart').on('click',function(e){
        		/*
        		1.이벤트처리(클래스)
        		2.Controller로 전송할데이타얻기 
        		3.Controller로 담기요청 ajax  방식으로요청
        		*/
        		if('${sUserId}'===''){
    	    		alert('로그인하세요!');
    	    		location.href='account-login';
        			e.stopPropagation();
        		}else{
        			var params={
        						'p_no':$(e.target).attr('p-no'),
        						'cart_qty':1
        				  		};
        			cart_add_action_rest(params);
        		}
       		});
        	/***********************************************/
    		
    		
    		/*************.remove-from-cart[REMOVE CART ITEM 버튼]이벤트처리***************/	
    		$('.remove-from-cart').on('click',function(e){
    			var cart_no = $(e.target).attr('cart-no');
    			cart_delete_item_action_rest(cart_no);
    			e.preventDefault();
    		});
    		/*************.btn-clear-cart[CLEAR CART 버튼]이벤트처리***************/	
     		$('.btn-clear-cart').on('click',function(e){
     			cart_delete_all_item_action_rest();
     		});
     		/******** .count-input select[카트수량변경]이벤트처리************/
        	$('.count-input select').on('change',function(e){
        			var cart_no=$(e.target).attr('cart-no');
        			var cart_qty=this.value;
        			var params={
        					"cart_no":cart_no,
        					"cart_qty":cart_qty
        			};
        			cart_update_item_action_rest(params);
        			
        			
        	});
     		
        	$(".alert").fadeTo(500, 500).slideUp(500, function() {
        	      $(".alert").slideUp(500);
        	 });
        	
    	});
    </script>
  </body>
</html>