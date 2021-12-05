package com.epam.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;

import com.epam.test.ProductEnum;
import com.epam.test.model.OrderEntryItem;
import com.epam.test.model.OrderModel;
import com.epam.test.model.OrderRequest;
import com.epam.test.model.ProductModel;
import com.epam.test.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
	
	
	@Mock
	OrderService orderService;
	
	@InjectMocks
	OrderController controller;
	
	
	@Test
	public void testPlaceOrder() {
		List<OrderEntryItem> orderItems = new ArrayList<OrderEntryItem>();
		ProductModel product = new ProductModel();
		product.setName(ProductEnum.APPLE.name());
		product.setPrice(ProductEnum.APPLE.price());

		OrderEntryItem orderEntry = new OrderEntryItem();
		orderEntry.setProduct(product);
		orderEntry.setQuantity(5);
		orderItems.add(orderEntry);
		
		String customerId = "customer1";
		OrderModel orderModel = new OrderModel("Arun");
		Mockito.when(orderService.placeOrder(Mockito.any())).thenReturn(orderModel);
	
		OrderRequest request = new OrderRequest(orderItems, customerId);
		ResponseEntity<OrderModel> response = controller.placeOrder(request);
		
		
	OrderModel order = 	response.getBody();
	assertEquals(order.getCustomerId(), "Arun");
	}
}
