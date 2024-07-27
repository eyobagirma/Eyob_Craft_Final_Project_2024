package com.eyob.finalProjcet.CustomersAPI.service;

import com.eyob.finalProjcet.CustomersAPI.dto.CustomersResponse;
import com.eyob.finalProjcet.CustomersAPI.model.Customers;


public interface CustomersService {

	public CustomersResponse createNewCustomer(Customers customers);

	public CustomersResponse updateExistingCustomer(int customerId, Customers customers);

	public CustomersResponse findByCustomerId(int customerId);

}
