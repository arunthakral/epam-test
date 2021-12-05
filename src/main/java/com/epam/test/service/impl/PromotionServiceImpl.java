package com.epam.test.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.epam.test.enums.ProductEnum;
import com.epam.test.model.DiscountEntryItem;
import com.epam.test.model.OrderEntryItem;
import com.epam.test.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService  {

	@Override
	public DiscountEntryItem applyEligiblePromotion(OrderEntryItem orderEntryItem) {
		
		if(ProductEnum.APPLE.code().equalsIgnoreCase(orderEntryItem.getProduct().getName())) {
			return applePromotion(orderEntryItem);
		} else if(ProductEnum.ORANGE.code().equalsIgnoreCase(orderEntryItem.getProduct().getName())) {
			return orangePromotion(orderEntryItem);
		}
		
		return null;
	}
	
	
	private DiscountEntryItem orangePromotion(OrderEntryItem orderEntryItem) {
		DiscountEntryItem  discountModel= new DiscountEntryItem();
		
		discountModel.setProduct(orderEntryItem.getProduct());
		discountModel.setQuantity(orderEntryItem.getQuantity()/2);
		discountModel.setPrice(BigDecimal.ZERO);
		discountModel.setDescription("Get third orange free with two oranges. ");
		return discountModel;
	}


	private DiscountEntryItem applePromotion(OrderEntryItem item) {
		
		DiscountEntryItem  discountModel= new DiscountEntryItem();
		discountModel.setProduct(item.getProduct());
		discountModel.setPrice(BigDecimal.ZERO);
		discountModel.setDescription("Enjoy our BOGO offer.");
		discountModel.setQuantity(item.getQuantity());
		return discountModel;
	}
	
	
}
