package com.eyob.finalProject.OrdersAPI.service;

import com.eyob.finalProject.OrdersAPI.dto.OrdersRequest;
import com.eyob.finalProject.OrdersAPI.dto.OrdersResponse;
import com.eyob.finalProject.OrdersAPI.dto.OrdersUpdateRequest;

public interface OrdersService {
	
	public OrdersResponse createOrder(OrdersRequest ordersRequest);
		
	public OrdersResponse updateOrder(OrdersUpdateRequest ordersUpdateRequest);
	
	public OrdersResponse retrieveOrder(int orderId);
	
	
	

}
