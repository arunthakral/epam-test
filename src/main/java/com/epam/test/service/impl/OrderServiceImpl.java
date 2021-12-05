package com.epam.test.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.test.daos.OrderDaoImpl;
import com.epam.test.model.DiscountEntryItem;
import com.epam.test.model.OrderModel;
import com.epam.test.model.OrderRequest;
import com.epam.test.service.OrderService;
import com.epam.test.service.PromotionService;
import com.epam.test.util.OrderUtil;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	PromotionService promotionService;
	
	@Autowired
	OrderDaoImpl orderDao;
	
	@Override
	public OrderModel placeOrder(OrderRequest orderRequest) {

		// validateCart
		// validateAvailableQuantity
		OrderModel order = new OrderModel(orderRequest.getCustomerId());

		orderRequest.getOrderItems().stream().forEach(orderItem -> {
			orderItem.getProduct()
					.setPrice(OrderUtil.getPriceForProduct(orderItem.getProduct().getName().toLowerCase()));
			orderItem
					.setEntryPrice(orderItem.getProduct().getPrice().multiply(new BigDecimal(orderItem.getQuantity())));
			order.getItems().add(orderItem);
			
			
			DiscountEntryItem discount = promotionService.applyEligiblePromotion(orderItem);
			orderItem.setDiscount(discount);

			order.setTotalPrice(order.getTotalPrice().add(orderItem.getEntryPrice()));
			
			if (null != orderItem.getDiscount()) {
				order.setTotalPrice(order.getTotalPrice().add(orderItem.getDiscount().getPrice()));
			}
			
			
		});
		orderDao.addOrder(order);
		return order;

	}
	
	@Override
	public List<OrderModel> getAllOrders() {
		return orderDao.getAllOrders();
	}

	@Override
	public OrderModel getOrderById(long orderId) {
		return orderDao.getOrderById(orderId);

	}
}
