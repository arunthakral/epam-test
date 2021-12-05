package com.epam.test.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class OrderRequest {
	
	@ApiModelProperty(notes = "Id of the cusomter",name="Customer Id",required=true, value = "testcustomer")
	@NotBlank(message = "Customer Id cannot be blank")
	private String customerId;
	
	@ApiModelProperty(notes = "list of OrderItems",name="orderItems",required=true)
	@NotEmpty(message = "Please add items to order.")
	private List<OrderEntryItem> orderItems;
	
	public OrderRequest(List<OrderEntryItem> orderItems, String customerId) {
		super();
		this.customerId = customerId;
		this.orderItems = orderItems;
	}
	
	 public String getCustomerId() {
		 return customerId;
	 }
	 
	 public void setCustomerId(String customerId) {
		 this.customerId = customerId;
	 }
	public List<OrderEntryItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderEntryItem> orderItems) {
		this.orderItems = orderItems;
	}



}
