package com.eyob.finalProject.LeadsAPI.service;

import com.eyob.finalProject.LeadsAPI.dto.Address;
import com.eyob.finalProject.LeadsAPI.dto.CustomFields;
import com.eyob.finalProject.LeadsAPI.dto.LeadsResponse;
import com.eyob.finalProject.LeadsAPI.dto.LeadsToCustomersResponse;
import com.eyob.finalProject.LeadsAPI.model.Leads;

public interface LeadsService {

	public LeadsResponse createLeads(Leads leads);

	public LeadsToCustomersResponse convertLeads(Address newAddress,
			CustomFields newCustomFields, String notes,
			int leadId);

}
