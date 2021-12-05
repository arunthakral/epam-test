package com.epam.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.test.enums.ProductEnum;
import com.epam.test.model.DiscountEntryItem;
import com.epam.test.model.OrderEntryItem;
import com.epam.test.model.ProductModel;
import com.epam.test.service.impl.PromotionServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PromotionServiceImplTest {
	
	@InjectMocks
	PromotionServiceImpl promotionService;
	
	@Test
	public void applyApplePromotion() {
		OrderEntryItem orderEntry = new OrderEntryItem();
		ProductModel product = new ProductModel();
		product.setName(ProductEnum.APPLE.name());
		product.setPrice(ProductEnum.APPLE.price());
		orderEntry.setProduct(product);
		orderEntry.setQuantity(5);
		
	DiscountEntryItem discountEntry =  	promotionService.applyEligiblePromotion(orderEntry);
	
	assertNotNull(discountEntry);
	assertEquals(orderEntry.getQuantity(), discountEntry.getQuantity());
	assertEquals(BigDecimal.ZERO, discountEntry.getPrice());
	
	}
	
	@Test
	public void applyOrangePromotion() {
		OrderEntryItem orderEntry = new OrderEntryItem();
		ProductModel product = new ProductModel();
		product.setName(ProductEnum.ORANGE.name());
		product.setPrice(ProductEnum.ORANGE.price());
		orderEntry.setProduct(product);
		orderEntry.setQuantity(6);
		
	DiscountEntryItem discountEntry =  	promotionService.applyEligiblePromotion(orderEntry);
	
	assertNotNull(discountEntry);
	assertEquals(3, discountEntry.getQuantity());
	assertEquals(ProductEnum.ORANGE.name(), discountEntry.getProduct().getName());
	assertEquals(BigDecimal.ZERO, discountEntry.getPrice());
	
	}
	
	@Test
	public void anyotherProductPromotion() {
		OrderEntryItem orderEntry = new OrderEntryItem();
		ProductModel product = new ProductModel();
		product.setName("banana");
		product.setPrice(BigDecimal.valueOf(50));
		orderEntry.setProduct(product);
		orderEntry.setQuantity(6);
		
	DiscountEntryItem discountEntry =  	promotionService.applyEligiblePromotion(orderEntry);
	assertNull(discountEntry);
	
	}

}
