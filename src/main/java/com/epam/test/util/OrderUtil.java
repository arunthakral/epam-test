package com.epam.test.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OrderUtil {
	static long leftLimit = 10000000L;
	static long rightLimit = 99999999990L;

	static Map<String, BigDecimal> productPrices = new HashMap() {
		{
			put("apple", BigDecimal.valueOf(0.25));
			put("orange",  BigDecimal.valueOf(0.60));
			put("others",  BigDecimal.valueOf(0.50));
		}
	};

	public static Long getRandomOrderId() {

		return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	}

	public static BigDecimal getPriceForProduct(String productName) {

		BigDecimal reval = productPrices.get(productName);
		return null != reval ? reval : productPrices.get("others");
	}

}
