/******카트아이템추가[cart_add_action_rest]*******/
var cart_add_action_rest=function(params){
	
	$.ajax({
			url:'cart_add_action_rest',
			method:'POST',
			data:params,
			dataType:'text',
			success:function(resultText){
				if(resultText.trim()==='true'){
					common_header_cart_info_change();
				}else{
					alert('add cart error!!');
				}
			}
	});
	
};

/*******카트아이템한개삭제[cart_delete_item_action_rest]**************/
var cart_delete_item_action_rest=function(cart_no){
	$.ajax({
		url:'cart_delete_item_action_rest',
		method:'POST',
		dataType:'json',
		data:'cart_no='+cart_no,
		success:function(resultJson){
			console.log(resultJson);
			/***********cart 에서아이템삭제****************/
			$('.shopping-cart table tr').each(function(i,element){
				 let find_cart_no=$(element).find('.remove-from-cart .icon-cross').attr('cart-no');
				 if(find_cart_no==cart_no){
					$(element).fadeOut(500,function(){
						$(element).remove();
						/*카트체크아웃버튼,카트총가격변경*/
						if(resultJson.cart_size==0){
							$('.btn-cart-checkout').attr('disabled','disabled');
						}
						$('.shopping-cart-footer .subtotal').html('&#8361;'+resultJson.cart_tot_price);
						
						/*공통헤더카트정보갱신*/
						common_header_cart_info_change();
					});
					
				 }			
			});
			
			/***********공통헤더 dropdown cart 에서아이템삭제****************/	
			$('.cart .dropdown-product-item').each(function(i,element){
				 let find_cart_no=$(element).find('.dropdown-product-remove .icon-cross').attr('cart-no');
				  if(find_cart_no==cart_no){
					$(element).fadeOut(500,function(){
						$(element).remove();
						/*카트체크아웃버튼,카트총가격변경*/
						if(resultJson.cart_size==0){
							$('.btn-cart-checkout').attr('disabled','disabled');
						}
						$('.cart .dropdown-subtotal').html('&#8361;'+resultJson.cart_tot_price);
						/*공통헤더카트정보갱신*/
						common_header_cart_info_change();
						
					});
				 }		
			});
			
		}
	});
};
/**********************************************************************/

/*******카트전체비우기[cart_delete_all_item_action_rest]******************/
var cart_delete_all_item_action_rest=function(){
	$.ajax({
		url:'cart_delete_all_item_action_rest',
		method:'POST',
		dataType:'json',
		success:function(resultJson){
			
			$('.shopping-cart table tbody').fadeOut(function(){
				$(this).remove();
				/*카트체크아웃버튼,카트총가격변경*/
				if(resultJson.cart_size==0){
					$('.btn-cart-checkout').attr('disabled','disabled');
				}
				$('.cart .dropdown-subtotal').html('&#8361;'+resultJson.cart_tot_price);
				
				/*공통헤더카트정보갱신*/
				common_header_cart_info_change();
			});
			
			
		}
	});
};

/*******카트아이템수량수정[cart_update_item_action_rest]******************/
var cart_update_item_action_rest=function(params){
	$.ajax({
		url:'cart_update_item_action_rest',
		method:'POST',
		data:params,
		dataType:'json',
		success:function(jsonResult){
			$('#subtotal-'+jsonResult.cart_no).html('₩ '+ jsonResult.cart_item_subtotal.toLocaleString('en'));				
			$('.shopping-cart-footer .subtotal').html('₩ '+jsonResult.tot_price.toLocaleString('en'));			
			common_header_cart_info_change();
		}
	});
};
 /**********************************************/
 /*
 		[ {
		    "cart_no": 26,
		    "user": {
		      "userId": "guard1",
		      "password": "1111",
		      "name": "김경호1",
		      "email": "guard1@korea.com"
		    },
		    "product": {
		      "p_no": 1,
		      "p_name": "비글",
		      "p_price": 550000,
		      "p_image": "bigle.png",
		      "p_desc": "기타 상세 정보 등...",
		      "p_click_count": 0
		    },
		    "cart_qty": 1
		  },{},{}]
*/
/*****공통헤더카트정보갱신[cart_item_list_rest]**********/
var common_header_cart_info_change=function(){
	$.ajax({
		url:'cart_item_list_rest',
		method:'GET',
		success:function(cartItemArray){
			$('.count').html(cartItemArray.length);

			$('.cart .toolbar-dropdown').html('');
			var tot_price=0;
			$.each(cartItemArray,function(i,cartItem){
				tot_price+=cartItem.product.p_price*cartItem.cart_qty;
				$('.cart .toolbar-dropdown').append(
						`<div class="dropdown-product-item">
							<span class="dropdown-product-remove"><i class="icon-cross" cart-no="${cartItem.cart_no}"></i></span>
							<a class="dropdown-product-thumb" href="shop-single"><img src="img/cart-dropdown/${cartItem.product.p_image}" alt="${cartItem.product.p_name}"></a>
							<div class="dropdown-product-info">
								<a class="dropdown-product-title" href="shop-single?p_no=${cartItem.product.p_no}">${cartItem.product.p_name}</a>
								<span class="dropdown-product-details">
									${cartItem.cart_qty} x	₩ ${cartItem.product.p_price.toLocaleString('en')}
								</span>
							</div>
						</div>`);
			});
			
			let disabled_attr="";
			if(cartItemArray.length==0){
				disabled_attr="disabled='disabled'";
			}
			
			
			$('.cart .toolbar-dropdown').append(`
				<div class="toolbar-dropdown-group">
					<div class="column">
						<span class="text-lg">Total:</span>
					</div>
					<div class="column text-right">
						<span class="text-lg text-medium">₩ ${tot_price.toLocaleString('en')}&nbsp;
						</span>
					</div>
				</div>
				<div class="toolbar-dropdown-group">
					<div class="column">
						<a class="btn btn-sm btn-block btn-secondary" href="cart">View
							Cart</a>
					</div>
					<div class="column">
						<a class="btn btn-sm btn-block btn-success"  ${disabled_attr} href="checkout-address.html">Checkout</a>
					</div>
				</div>
			`);
			
			
			$('.cart .subtotal').html('&#8361; '+tot_price.toLocaleString('en'));
		}
	});
};

/*********************************************************/


