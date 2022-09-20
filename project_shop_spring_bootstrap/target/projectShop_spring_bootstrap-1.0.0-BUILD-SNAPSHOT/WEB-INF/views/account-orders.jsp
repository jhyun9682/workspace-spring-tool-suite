<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>My Orders
    </title>
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
    <style type="text/css">
    	button.btn, button.btn-xs {
		  
		}
		.remove-from-order{
		  	color: #ff5252;
		}
    </style>
  </head>
  <!-- Body-->
  <body>
    <!-- Open Ticket Modal-->
    <div class="modal fade" id="orderDetails" tabindex="-1">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Order No  - 34VB5540K83</h4>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          </div>
          <div class="modal-body">
            <div class="table-responsive shopping-cart mb-0">
              <table class="table">
                <thead>
                  <tr>
                    <th>Product Name</th>
                    <th class="text-center">Subtotal</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>
                      <div class="product-item"><a class="product-thumb" href="shop-single"><img src="img/shop/cart/01.jpg" alt="Product"></a>
                        <div class="product-info">
                          <h4 class="product-title"><a href="shop-single.html">Unionbay Park<small>x 1</small></a></h4><span><em>Size:</em> 10.5</span><span><em>Color:</em> Dark Blue</span>
                        </div>
                      </div>
                    </td>
                    <td class="text-center text-lg text-medium">$43.90</td>
                  </tr>
                  <tr>
                    <td>
                      <div class="product-item"><a class="product-thumb" href="shop-single.html"><img src="img/shop/cart/02.jpg" alt="Product"></a>
                        <div class="product-info">
                          <h4 class="product-title"><a href="shop-single.html">Daily Fabric Cap<small>x 2</small></a></h4><span><em>Size:</em> XL</span><span><em>Color:</em> Black</span>
                        </div>
                      </div>
                    </td>
                    <td class="text-center text-lg text-medium">$24.89</td>
                  </tr>
                  <tr>
                    <td>
                      <div class="product-item"><a class="product-thumb" href="shop-single.html"><img src="img/shop/cart/03.jpg" alt="Product"></a>
                        <div class="product-info">
                          <h4 class="product-title"><a href="shop-single.html">Cole Haan Crossbody<small>x 1</small></a></h4><span><em>Size:</em> -</span><span><em>Color:</em> Turquoise</span>
                        </div>
                      </div>
                    </td>
                    <td class="text-center text-lg text-medium">$200.00</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <hr class="mb-3">
            <div class="d-flex flex-wrap justify-content-between align-items-center pb-2">
              <div class="px-2 py-1">Subtotal: <span class='text-medium tot-price'>₩ 289.68</span></div>
              <div class="px-2 py-1">Shipping: <span class='text-medium'>₩ 0.0</span></div>
              <div class="px-2 py-1">Tax: <span class='text-medium'>₩ 0.0</span></div>
              <div class="text-lg px-2 py-1">Total: <span class='text-medium tot-price'>₩ 315.60</span></div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Off-Canvas Category Menu-->
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
            <h1>My Orders</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="index.html">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li><a href="account-orders.html">Account</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>My Orders</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-2">
        <div class="row">
       
          <div class="col-lg-4">
          <!-- include_account_left_sidebar.jsp  start-->
          <jsp:include page="include_account_left_sidebar.jsp"/> 
          <!-- include_account_left_sidebar.jsp  end  -->
          </div>
        
          <div class="col-lg-8">
            <div class="padding-top-2x mt-2 hidden-lg-up"></div>
            <div class="table-responsive">
              <table class="order-list-table table table-hover margin-bottom-none">
                <thead>
                  <tr>
                    <th>Order #</th>
                    <th>Date Purchased</th>
                    <th>Status</th>
                    <th>Total</th>
                    <th style="padding-bottom: 5px;padding-top: 5px;padding-left: 50px;">
                    	<c:if test="${empty orderList}">	
                    		<a class=" btn-clear-order btn btn-sm btn-outline-danger" disabled="disabled" href="#" style="margin: 0px">Clear Order</a>
                    	</c:if>
                    	<c:if test="${!empty orderList}">	
                    		<a class=" btn-clear-order btn btn-sm btn-outline-danger" href="#" style="margin: 0px">Clear Order</a>
                    	</c:if>
                    </th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderList}" var="order">	
                  <tr>
                    <td><a class="link-order-detail text-medium navi-link" href="#" data-toggle="modal" data-target="#orderDetails">${order.o_no}</a></td>
                    <td>${order.o_date}</td>
                    <td><span class="text-success">Delivered</span></td>
                    <td><span class="text-medium">&#8361; <s:eval expression="new java.text.DecimalFormat('#,###').format(order.o_price)"/></span></td>
                 	<td class="text-center"><span class="text-danger text-medium">
                 	 	<a class="remove-from-order" href="#" data-toggle="tooltip" title=""  data-original-title="Remove Order # ${order.o_no}">
                		<i class="icon-cross" order-no="${order.o_no}"></i>
                		</a>
                		</span>
                	</td>
                  </tr>
                </c:forEach>	  
                </tbody>
              </table>
            </div>
            <hr>
           <!--  <div class="text-right"><a class="btn btn-link-primary margin-bottom-none" href="#"><i class="icon-download"></i>&nbsp;Order Details</a></div> -->
          </div>
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
    <script src="js/custom.order.js"></script>
    <script src="js/custom.account.js"></script>
    <script type="text/javascript">
        /******account왼쪽메뉴 선택*************/
    	account_left_sidebar_select('${requestScope['javax.servlet.forward.request_uri'].substring(pageContext.request.contextPath.length()+1)}');
        /**********주문상세메뉴이벤트************************/
        $('#orderDetails').on('show.bs.modal',function(e){
			var o_no=$(e.relatedTarget).text().trim();
			var params={'o_no':o_no};
			order_detail_rest(params)
		});
        /**********주문한개삭제메뉴이벤트************************/
        $('.order-list-table').on('click','.remove-from-order',function(e){
        	console.log($(e.target).attr('order-no'));
        	var params={'o_no':$(e.target).attr('order-no')}
        	order_item_delete_action_rest(params);
        });
        /**********주문전체삭제메뉴이벤트************************/
        $('.order-list-table').on('click','.btn-clear-order',function(e){
        	var params={};
        	order_all_delete_action_rest(params);
        });
		
    </script>
  </body>
</html>














