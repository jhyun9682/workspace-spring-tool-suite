package com.itwill.exercises;
@Service(value = "orderService")
public class OrderServiceImpl {
	@AutoWire
	@Qualifier("orderDao")
private OrderDaoImpl orderDaoImpl;

public OrderServiceImpl() {
	// TODO Auto-generated constructor stub
}
@AutoWire
public OrderServiceImpl(@Qualifier(value = "orderDao") OrderDaoImpl orderDaoImpl) {
	super();
	this.orderDaoImpl = orderDaoImpl;
}
public OrderDaoImpl getOrderDaoImpl() {
	return orderDaoImpl;
}
@AutoWire(value = "orderDao")
public void setOrderDaoImpl(OrderDaoImpl orderDaoImpl) {
	this.orderDaoImpl = orderDaoImpl;
}

}
