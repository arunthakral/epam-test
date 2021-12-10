package com.epam.test.controller;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
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
	/**
	 * gets list of all the orders.
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<List<OrderModel>> getAllOrders(){
		
		List<OrderModel> orders = orderService.getAllOrders();
		return ResponseEntity.ok(orders);
	}
	
	/**
	 * gets order by id.
	 * @param orderId- the orderId
	 * @return
	 */
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderModel> getOrderById(@PathVariable("orderId") @Validated @Size(min = 0) Long  orderId){
		
		OrderModel order = orderService.getOrderById(Long.valueOf(orderId));
		return ResponseEntity.ok(order);
	}

}
