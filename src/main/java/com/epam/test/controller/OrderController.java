package com.epam.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.test.model.OrderModel;
import com.epam.test.model.OrderRequest;
import com.epam.test.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/orders")
@Api("Controller for Order Transactions")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	/**
	 * places an order request.
	 * @param request OrderRequest {@linkplain OrderRequest}
	 * @return
	 */
	@PostMapping(path = "/placeOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Places the order for a user. with items in the list.", response = OrderModel.class,
	httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"), 
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	public ResponseEntity<OrderModel> placeOrder ( @RequestBody @Validated OrderRequest request) {
		
		OrderModel order = orderService.placeOrder(request);
		
		return ResponseEntity.ok(order);
		
	}

}
