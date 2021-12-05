package com.epam.test.service;

import com.epam.test.model.DiscountEntryItem;
import com.epam.test.model.OrderEntryItem;

/**
 * Service for promotions on orders.
 * @author arunt
 *
 */
public interface PromotionService {
	
	/**
	 * applies the eligible promotions for the entry item.
	 * @param orderEntryItem
	 * @return
	 */
	public DiscountEntryItem applyEligiblePromotion(OrderEntryItem orderEntryItem);

}