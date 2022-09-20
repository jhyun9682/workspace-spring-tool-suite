/*********공통헤더카트아이템삭제[include_common_top.jsp]*************************/
$('.cart').on('click','.dropdown-product-item .dropdown-product-remove',function(e){
	cart_delete_item_action_rest($(e.target).attr('cart-no'));
}); 
/********************************************************************************/
