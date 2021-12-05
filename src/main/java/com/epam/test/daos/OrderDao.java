package com.epam.test.daos;

import java.util.List;

import com.epam.test.model.OrderModel;

/**
 * Dao class for order operations.
 * @author arunt
 *
 */
public interface OrderDao {

	/**
	 * gets list of all orders.
	 * @return
	 */
	List<OrderModel> getAllOrders();

	/**
	 * gets order by orderId
	 * @param orderId
	 * @return
	 */
	OrderModel getOrderById(long orderId);

	/**
	 * Adds order to the store.
	 * @param order2
	 * @return 
	 */
	void addOrder(OrderModel order2);

	/**
	 * deletes all orders from system
	 */
	void clearAllOrders();

}
