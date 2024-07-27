package com.eyob.finalProject.OrdersAPI.model;

import jakarta.persistence.Embeddable;
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

@Embeddable
public class ShippingAddress {

	private String street;
	private String city;
	private String state;
	private String zipcode;
}
