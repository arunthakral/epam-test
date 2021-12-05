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
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.epam.test.enums.ProductEnum;
import com.epam.test.model.OrderEntryItem;
import com.epam.test.model.OrderModel;
import com.epam.test.model.OrderRequest;
import com.epam.test.model.ProductModel;
import com.epam.test.service.OrderService;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

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
	

	@Test
	public void testGetAllOrders() {
		List<OrderModel> orders = new 	ArrayList<>();
		orders.add(new OrderModel("Arun"));
		orders.add(new OrderModel("Arun2"));
		orders.add(new OrderModel("Arun4"));
		
		Mockito.when(orderService.getAllOrders()).thenReturn(orders);
		
		ResponseEntity<List<OrderModel>> response = controller.getAllOrders();
		
		assertEquals(3, response.getBody().size());
	}
	@Test
	public void testGetOrderById() {
		OrderModel o = new OrderModel("Arun4");
		
		Mockito.when(orderService.getOrderById(Mockito.anyLong())).thenReturn(o);
		
		ResponseEntity<OrderModel> response = controller.getOrderById(Long.valueOf(324798));
		
		assertEquals("Arun4", response.getBody().getCustomerId());
	}

}