package com.epam.test.service;

import java.util.List;

import com.epam.test.model.OrderModel;
import com.epam.test.model.OrderRequest;

/**
 * @author arunt
 * Service class for order related operations.
 */
public interface OrderService {
	
	/**
	 * places order for request
	 * @param order   the request for order. {@linkplain OrderRequest}
	 * @return
	 */
	OrderModel placeOrder(OrderRequest order);

	/**
	 * gets list of all the orders in the system. 
	 * @return
	 */
	List<OrderModel> getAllOrders();

	/**
	 * gets a particular order based on orderId.
	 * @param orderId
	 * @return
	 */
	OrderModel getOrderById(long orderId);

}
