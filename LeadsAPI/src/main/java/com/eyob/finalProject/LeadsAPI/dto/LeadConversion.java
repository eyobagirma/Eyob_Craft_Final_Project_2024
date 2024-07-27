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

public class LeadConversion {

	Address address;
	CustomFields customFields;
	String notes;
	int leadId;
}
