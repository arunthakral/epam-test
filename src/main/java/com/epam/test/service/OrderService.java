package com.epam.test.service;

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

}
