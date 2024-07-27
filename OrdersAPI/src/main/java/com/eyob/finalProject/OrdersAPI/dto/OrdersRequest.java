package com.eyob.finalProject.OrdersAPI.dto;

import java.util.List;

import com.eyob.finalProject.OrdersAPI.model.Products;
import com.eyob.finalProject.OrdersAPI.model.ShippingAddress;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrdersRequest {

	private int customerId;

	private List<Products> products;
	private double discount;
	private ShippingAddress shippingAddress;
	private String notes;

}
