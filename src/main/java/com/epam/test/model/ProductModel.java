package com.epam.test.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class ProductModel {
	
	@ApiModelProperty(notes = "Product name ",name="name",required=true)	
	private String name;
	
	@ApiModelProperty(notes = "Product price ",name="Price of Product",hidden=true)	
	private BigDecimal price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
