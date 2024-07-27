package com.eyob.finalProject.OrdersAPI.model;

import java.util.List;

import com.eyob.finalProject.OrdersAPI.dto.Customers;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;

	@ElementCollection
	@Column(name = "products")
	private List<Products> products;

	private double totalAmount;
	private String status;
	private double discount;
	private ShippingAddress shippingAddress;
	private String notes;
	
	

	
}
