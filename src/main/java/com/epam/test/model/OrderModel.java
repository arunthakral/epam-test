package com.epam.test.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import com.epam.test.util.OrderUtil;

public class OrderModel {
	public long orderId;
	private String customerId;
	private LocalDateTime orderDate;
	private BigDecimal totalPrice;
	private Currency currency;
	private List<OrderEntryItem> items;
	
	

	public OrderModel(String customerId) {
		super();
		this.customerId = customerId;
		this.items = new ArrayList<>();
		this.orderDate = LocalDateTime.now();
		this.totalPrice = new BigDecimal(0);
		this.currency = Currency.getInstance(Locale.US);
		this.orderId = OrderUtil.getRandomOrderId();
	}
	
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public List<OrderEntryItem> getItems() {
		return items;
	}
	public void setItems(List<OrderEntryItem> items) {
		this.items = items;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", items=" + items + ", customerId=" + customerId + ", orderDate="
				+ orderDate + ", totalPrice=" + totalPrice + ", currency=" + currency + "]";
	}


	public BigDecimal getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
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


	@Override
	public int hashCode() {
		return Objects.hash(currency, customerId, items, orderDate, orderId, totalPrice);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderModel other = (OrderModel) obj;
		return Objects.equals(currency, other.currency) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(items, other.items) && Objects.equals(orderDate, other.orderDate)
				&& orderId == other.orderId && Objects.equals(totalPrice, other.totalPrice);
	}
	
	
}
