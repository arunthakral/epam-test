package com.epam.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.test.ProductEnum;
import com.epam.test.model.OrderEntryItem;
import com.epam.test.model.OrderModel;
import com.epam.test.model.OrderRequest;
import com.epam.test.model.ProductModel;
import com.epam.test.service.impl.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	@InjectMocks
	OrderServiceImpl orderService;

	@Test
	public void TestplaceOrder() {

		List<OrderEntryItem> orderItems = new ArrayList<OrderEntryItem>();
		ProductModel product = new ProductModel	();
		product.setName(ProductEnum.APPLE.name());
		product.setPrice(ProductEnum.APPLE.price());

		OrderEntryItem orderEntry = new OrderEntryItem();
		orderEntry.setProduct(product);
		orderEntry.setQuantity(5);
		orderItems.add(orderEntry);
		
		String customerId = "customer1";
		OrderRequest request = new OrderRequest(orderItems, customerId);
		OrderModel order = orderService.placeOrder(request);
		assertEquals(customerId, order.getCustomerId());
		assertEquals(new BigDecimal(5).multiply(ProductEnum.APPLE.price()), order.getTotalPrice());
		
	}


}
