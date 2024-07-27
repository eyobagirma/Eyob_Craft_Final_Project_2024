package com.eyob.finalProject.OrdersAPI.dto;

import java.util.List;

import com.eyob.finalProject.OrdersAPI.model.Orders;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@OneToMany(mappedBy = "customers", fetch = FetchType.LAZY)
	private List<Orders> orders;

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Address address;
	private String notes;
	private CustomFields customFields;


}
