package com.epam.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.test.daos.OrderDao;
import com.epam.test.daos.OrderDaoImpl;
import com.epam.test.model.OrderModel;

@ExtendWith(MockitoExtension.class)
public class OrderDaoImplTest {

	@InjectMocks
	OrderDao dao = new OrderDaoImpl();

	@BeforeEach
	public void setup() {
		OrderModel o1 = new OrderModel("arun1");
		OrderModel o2 = new OrderModel("arun4");
		OrderModel o3 = new OrderModel("arun5");
		o1.setOrderId(Long.valueOf("123456789"));
		o2.setOrderId(Long.valueOf("234567891"));
		o3.setOrderId(Long.valueOf("345678912"));

		dao.addOrder(o1);
		dao.addOrder(o2);
		dao.addOrder(o3);

	}

	@Test
	public void test_placeOrder() {
		OrderModel o5 = new OrderModel("arun1");
		o5.setOrderId(Long.valueOf("567891234"));
		dao.addOrder(o5);
		assertNotNull(dao.getOrderById(Long.valueOf("567891234")));

	}

	@Test
	public void test_getOrderById() {
		OrderModel o5 = new OrderModel("arun1");
		o5.setOrderId(Long.valueOf("567891234"));
		dao.addOrder(o5);
		assertNotNull(dao.getOrderById(Long.valueOf("123456789")));
		assertNotNull(dao.getOrderById(Long.valueOf("567891234")));

	}

	@Test
	public void test_getAllOrder() {
		OrderModel o5 = new OrderModel("arun1");
		o5.setOrderId(Long.valueOf("567891234"));
		dao.addOrder(o5);
		assertNotNull(dao.getAllOrders());
		assertEquals(4, dao.getAllOrders().size());

	}

	@AfterEach
	public void tearDown() {
		dao.clearAllOrders();

	}

}
