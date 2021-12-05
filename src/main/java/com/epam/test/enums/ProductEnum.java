package com.epam.test.enums;

import java.math.BigDecimal;

public enum ProductEnum {
	
	APPLE("APPLE", BigDecimal.valueOf(0.25)),
	ORANGE("ORANGE",BigDecimal.valueOf(0.60));
	
	private final String name;
	private final BigDecimal price;
	
	 ProductEnum(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String code() {
		return name;
	}

	public BigDecimal price() {
		return price;
	}
	
	
	 
	 
}
