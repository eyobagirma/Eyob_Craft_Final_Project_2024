package com.eyob.finalProjcet.CustomersAPI.controller;

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

import com.eyob.finalProjcet.CustomersAPI.model.Customers;
import com.eyob.finalProjcet.CustomersAPI.service.CustomersService;

@RestController
@RequestMapping("/api/auth/customers/ch1")

public class CustController {


	@Autowired
	CustomersService customersService;

	@PostMapping("/createCustomer")
	public ResponseEntity<?> createCustomer(@RequestBody Customers customers) {

		return new ResponseEntity<>(customersService.createNewCustomer(customers), HttpStatus.CREATED);
	}

	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<?> updateCustomer (@PathVariable ("customerId") int customerId, @RequestBody Customers customers) {
		
		return new ResponseEntity<>(customersService.updateExistingCustomer(customerId, customers),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/findCustomerById/{customerId}")
	public ResponseEntity<?> findCustomerById(@PathVariable("customerId") int customerId) {

		return new ResponseEntity<>(customersService.findByCustomerId(customerId), HttpStatus.FOUND);
	}

}
