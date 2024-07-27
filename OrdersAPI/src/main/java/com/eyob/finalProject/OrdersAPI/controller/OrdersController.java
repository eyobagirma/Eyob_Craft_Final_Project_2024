package com.eyob.finalProject.OrdersAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyob.finalProject.OrdersAPI.dto.OrdersRequest;
import com.eyob.finalProject.OrdersAPI.dto.OrdersUpdateRequest;
import com.eyob.finalProject.OrdersAPI.service.OrdersService;

@RestController
@RequestMapping("/api/auth/orders/ch3")
public class OrdersController {

	@Autowired
	OrdersService ordersService;

	@PostMapping("/createOrder")
	public ResponseEntity<?> createOrder(@RequestBody OrdersRequest ordersRequest) {
		
		return new ResponseEntity<>(ordersService.createOrder(ordersRequest), HttpStatus.CREATED);
	}

	@PutMapping("/updateOrder")
	public ResponseEntity<?> updateOrder(@RequestBody OrdersUpdateRequest ordersUpdateRequest) {

		return new ResponseEntity<>(ordersService.updateOrder(ordersUpdateRequest), HttpStatus.OK);
	}

	@GetMapping("/retrieveOrder/{orderId}")
	public ResponseEntity<?> retrieveOrder(@PathVariable("orderId") int orderId) {

		return new ResponseEntity<>(ordersService.retrieveOrder(orderId), HttpStatus.FOUND);
	}

}
