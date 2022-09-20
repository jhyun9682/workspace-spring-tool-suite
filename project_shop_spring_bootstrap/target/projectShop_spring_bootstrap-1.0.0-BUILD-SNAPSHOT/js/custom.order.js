/******주문상세보기[order_detail_rest]*******/
var order_detail_rest=function(params){
	
	$.ajax({
		url:'order_detail_rest',
		method:'POST',
		data:params,
		dataType:'json',
		success:function(order){
			$('#orderDetails').find('.modal-header .modal-title').html('Order No  - #'+order.o_no);
			$('#orderDetails .shopping-cart table > tbody').html('');
			let totPrice=0;
			$.each(order.orderItemList,function(i,orderItem){
				totPrice+= orderItem.oi_qty*orderItem.product.p_price;
				$('#orderDetails .shopping-cart table > tbody').append(`
						<tr>
	                    <td>
	                      <div class="product-item"><a class="product-thumb" href="shop-single"><img src="img/shop/cart/${orderItem.product.p_image}" alt="Product"></a>
	                        <div class="product-info">
	                          <h4 class="product-title"><a href="shop-single.html">${orderItem.product.p_name}<small>x ${orderItem.oi_qty}</small></a></h4><span><em>Size:</em> 소형</span><span><em>Color:</em> Dark Blue</span>
	                        </div>
	                      </div>
	                    </td>
	                    <td class="text-center text-lg text-medium">₩ ${(orderItem.oi_qty*orderItem.product.p_price).toLocaleString('en')}</td>
	                  </tr>
					`);
			});
			
			$('#orderDetails').find('.tot-price').html(`₩ ${totPrice.toLocaleString('en')}`);
			
		}
	});
	
};
/******주문1개삭제[order_detail_rest]*******/
var order_item_delete_action_rest=function(params){
	
	$.ajax({
		url:'order_item_delete_action_rest',
		method:'POST',
		data:params,
		dataType:'json',
		success:function(resultJson){
			$('.order-list-table tbody tr').each(function(i,element){
				if($(element).find('a.link-order-detail').text().trim()==resultJson.remove_order_no){
					$(element).fadeOut(500,function(){
						$(element).remove();
						/*account 공통메뉴 주문숫자변경*/
						$('.account-order-count.badge').html(resultJson.order_count);
					});
				}
			});
		}
	});
};
/******주문전체삭제[order_detail_rest]*******/
var order_all_delete_action_rest=function(params){
	
	$.ajax({
		url:'order_all_delete_action_rest',
		method:'POST',
		data:params,
		dataType:'json',
		success:function(resultJson){
			$('.order-list-table tbody tr').each(function(i,element){
					$(element).fadeOut(500,function(){
						$(element).remove();
						/*account 공통메뉴 주문숫자변경*/
						$('.account-order-count.badge').html(resultJson.order_count);
						$('.btn-clear-order').attr('disabled','disabled');
					});
			});
		}
	});
};