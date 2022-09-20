<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.lang.Math" %>    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="s"  uri="http://www.springframework.org/tags"%>	  
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>Login / Register Account
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
            <h1>Login / Register Account</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="index.html">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li><a href="account-orders.html">Account</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>Login / Register</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-2">
        <div class="row">
          <div class="col-md-6">
            <form id="form-account-login" class="login-box" method="post">
              <div class="row margin-bottom-1x">
                <div class="col-xl-4 col-md-6 col-sm-4"><a class="btn btn-sm btn-block facebook-btn" href="#"><i class="socicon-facebook"></i>&nbsp;Facebook login</a></div>
                <div class="col-xl-4 col-md-6 col-sm-4"><a class="btn btn-sm btn-block twitter-btn" href="#"><i class="socicon-twitter"></i>&nbsp;Twitter login</a></div>
                <div class="col-xl-4 col-md-6 col-sm-4"><a class="btn btn-sm btn-block google-btn" href="#"><i class="socicon-googleplus"></i>&nbsp;Google+ login</a></div>
              </div>
              <h4 class="margin-bottom-1x">Or using form below</h4>
              <div class="form-group input-group">
                <input class="form-control" type="text" placeholder="아이디" name="userId" id="loginUserId"  required><span class="input-group-addon"><i class="icon-bell"></i></span>
              </div>
              <div class="form-group input-group">
                <input class="form-control" type="password" placeholder="패쓰워드" name="password" id="loginPassword" required><span class="input-group-addon"><i class="icon-lock"></i></span>
              </div>
              <div class="d-flex flex-wrap justify-content-between padding-bottom-1x">
                <div class="custom-control custom-checkbox">
                  <input class="custom-control-input" type="checkbox" id="remember_me" checked>
                  <label class="custom-control-label" for="remember_me">Remember me</label>
                </div><a class="navi-link" href="account-password-recovery.html">Forgot password?</a>
              </div>
              <div class="text-center text-sm-right">
                <button class="btn btn-primary margin-bottom-none" type="submit" id="login-action-btn">Login</button>
              </div>
            </form>
          </div>
          <div class="col-md-6">
            <div class="padding-top-3x hidden-md-up"></div>
            <h3 class="margin-bottom-1x">No Account? Register</h3>
            <p>Registration takes less than a minute but gives you full control over your orders.</p>
            <form id="form-account-regist" class="row" method="post">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="userId">User Id </label>
                  <input class="form-control" type="text" id="userId" name="userId" required>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="name">User Name</label>
                  <input class="form-control" type="text" id="name" name="name"  required>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="email">E-mail Address</label>
                  <input class="form-control" type="email" id="email"  name="email"  required>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="phone">Phone Number</label>
                  <input class="form-control" type="text" id="phone" name="phone" required>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="password">Password</label>
                  <input class="form-control" type="password" id="password" name="password" required>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="repassword">Confirm Password</label>
                  <input class="form-control" type="password" id="repassword" id="repassword" required>
                </div>
              </div>
              <div class="col-12 text-center text-sm-right">
                <button class="btn-account-register btn btn-primary margin-bottom-none"  type="submit">Register</button>
                <button class="btn-account-reset btn btn-primary margin-bottom-none"  type="reset">Cancle</button>
              </div>
            </form>
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
    
    <script src="js/custom.account.js"></script>
    <script type="text/javascript">
    	$(function(){
    		/**************회원가입폼 유효성체크*********************/
    		$('#form-account-regist').on('ropertychange change keyup paste input',function(e){
        		if($('#password').val()!=$('#repassword').val()){
        			$('#password,#repassword').css('border','0.5px dotted orange');
        			$('#repassword').tooltip({'trigger':'hover', 'title':'패쓰워드와 패쓰워드확인이 일치하여야합니다.'});
        			$('#repassword').tooltip('show');
        			$('.btn-account-register').attr('disabled', 'disabled');
        		}else{
        			$('#password,#repassword').css('border','');
        			$('#repassword').tooltip('hide');
        			$('#repassword').tooltip('dispose');
        			$('.btn-account-register').removeAttr('disabled');
        		}	
        	});
    		/**************회원로그인폼 보더삭제*********************/
    		$('#form-account-login').on('propertychange change keyup paste input',function(e){
        		$('#form-account-login input').css('border','');
        	});
    		/**********로그인[page]************
    		$('.login-box').on('submit',function(e){
    			var loginFrm = e.target;
    			loginFrm.action='account-login';
    			loginFrm.method='POST';
    			loginFrm.submit();
    		});
    		*/
    		/**********로그인submit버튼[ajax]************/
    		$('#form-account-login').on('submit',function(e){
    			var params=$(e.target).serialize();
    			account_login_action_rest(params);
    			e.preventDefault();
    		});
    		/**********회원가입submit버튼[ajax]************/
        	$('#form-account-regist').on('submit',function(e){
        		console.log('11111111');
    			var params=$(e.target).serialize();
    			$('#userId').css('border','');
    			$('#userId').tooltip('dispose');
    			$('#form-account-regist').tooltip('dispose');
        		console.log('222222');
        		account_write_action_rest(params);
        		console.log('444444');
    			e.preventDefault();
    		});
    		
    		
    	});
    	
    </script>
  </body>
</html>