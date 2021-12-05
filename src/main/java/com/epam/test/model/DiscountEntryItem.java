package com.epam.test.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class DiscountEntryItem {
	
	private ProductModel product;
	private String description;
	private int quantity;
	private BigDecimal price;
	private Currency currency = Currency.getInstance(Locale.US);

	

	@Override
	public String toString() {
		return "DiscountEntryItem [description=" + description + ", product=" + product + ", quantity=" + quantity
				+ ", entryPrice=" + price + ", currency=" + currency + "]";
	}

	/**
	 * @return the product
	 */
	public ProductModel getProduct() {
		return product;
	}
	

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductModel product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the entryPrice
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param entryPrice the entryPrice to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


}
