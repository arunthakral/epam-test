package com.epam.test.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epam.test.model.OrderModel;

@Component
public class OrderDaoImpl  implements OrderDao{
	
	private static Map<Long, OrderModel> order = new HashMap<>();
	
	@Override
	public  List<OrderModel> getAllOrders(){
		return  order.values().stream().collect(Collectors.toList());
	}
	
	@Override
	public  OrderModel getOrderById(long orderId) {
		return order.get(orderId);
	}

	@Override
	public void addOrder(OrderModel order2) {
		 order.put(order2.getOrderId(), order2);
		
	}
	
	@Override
	public void clearAllOrders() {
		order.clear();
	}
	

}
