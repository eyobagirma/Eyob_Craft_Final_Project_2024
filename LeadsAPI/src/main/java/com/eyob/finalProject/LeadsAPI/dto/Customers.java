package com.eyob.finalProject.LeadsAPI.dto;


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

public class Customers {


	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Address address;
	private String notes;
	private CustomFields customFields;

}
