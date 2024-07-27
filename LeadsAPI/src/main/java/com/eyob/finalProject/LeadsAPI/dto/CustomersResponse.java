package com.eyob.finalProject.LeadsAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomersResponse {

	private Customers customers;
	private String message;
	private String statuscode;

}
