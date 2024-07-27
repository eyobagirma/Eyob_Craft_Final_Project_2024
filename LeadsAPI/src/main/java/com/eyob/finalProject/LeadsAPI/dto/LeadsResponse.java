package com.eyob.finalProject.LeadsAPI.dto;

import com.eyob.finalProject.LeadsAPI.model.Leads;

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

public class LeadsResponse {

	private Leads leads;
	private String message;
	private String statusCode;

}
