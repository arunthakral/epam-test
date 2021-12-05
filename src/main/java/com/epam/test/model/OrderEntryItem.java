package com.epam.test.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import io.swagger.annotations.ApiModelProperty;

public class OrderEntryItem {
	
	
	@ApiModelProperty(notes = "Product to order",name="product",required=true, allowableValues = "Orange,Apple")	
	private ProductModel product;

	@ApiModelProperty(notes = "Product Quantity ",name="quantity",required=true)	
	private int quantity;
	
	@ApiModelProperty(notes = "price",name="price",hidden = true)
	private BigDecimal entryPrice;
	
	private Currency currency = Currency.getInstance(Locale.US);
	
	@ApiModelProperty(notes = "discount",name="discount",hidden = true)
	private  DiscountEntryItem discount;
	

	public OrderEntryItem() {
		this.entryPrice = new BigDecimal(0);
	}


	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getEntryPrice() {
		return entryPrice;
	}

	public void setEntryPrice(BigDecimal entryPrice) {
		this.entryPrice = entryPrice;
	}

	public Currency getCurrency() {
		return currency;
	}


	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "OrderEntryItem [product=" + product + ", quantity=" + quantity + ", entryPrice=" + entryPrice
				+ ", currency=" + currency + ", discount=" + discount + "]";
	}


	/**
	 * @return the discount
	 */
	public DiscountEntryItem getDiscount() {
		return discount;
	}


	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(DiscountEntryItem discount) {
		this.discount = discount;
	}
	
	
	
}
