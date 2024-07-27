package com.eyob.finalProject.LeadsAPI.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eyob.finalProject.LeadsAPI.dto.Address;
import com.eyob.finalProject.LeadsAPI.dto.CustomFields;
import com.eyob.finalProject.LeadsAPI.dto.Customers;
import com.eyob.finalProject.LeadsAPI.dto.LeadsResponse;
import com.eyob.finalProject.LeadsAPI.dto.LeadsToCustomersResponse;
import com.eyob.finalProject.LeadsAPI.model.Leads;
import com.eyob.finalProject.LeadsAPI.repo.LeadsRepo;
import com.eyob.finalProject.LeadsAPI.service.LeadsService;

@Service
public class LeadsServiceImp implements LeadsService{

	@Autowired
	LeadsRepo leadsRepo;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public LeadsResponse createLeads(Leads leads) {
		
		leadsRepo.save(leads);
		
	try {
		
		LeadsResponse response = LeadsResponse.builder()
				
				.leads(leads)
				
				.message("Lead registration is complete.")
				
				.statusCode("1000")
				
				.build();
		
		return response;
		
	} catch (Exception e) {
		
		LeadsResponse response = LeadsResponse.builder()
				
				.message("Registration is not complete!")

				.statusCode("888")

				.build();

		return response;
	}
		
}

	@Override
	public LeadsToCustomersResponse convertLeads(Address newAddress, CustomFields newCustomFields, String notes,
			int leadId) {
//
//		leadsRepo.save(newAddress);
//		leadsRepo.save(newCustomFields);
//		leadsRepo.save(note);
		
		Optional<Leads> optional = leadsRepo.findById(leadId);

		if (optional.isPresent()) {

		Leads lead = optional.get();

			Customers customerFromLead = new Customers();

			customerFromLead.setFirstName(lead.getFirstName());
			customerFromLead.setLastName(lead.getLastName());
			customerFromLead.setEmail(lead.getEmail());
			customerFromLead.setPhone(lead.getPhone());
			customerFromLead.setAddress(newAddress);
			customerFromLead.setNotes(notes);
			customerFromLead.setCustomFields(newCustomFields);
			

			String CreateUrl = "http://localhost:9091/api/auth/customers/ch1/createCustomer";
			
			restTemplate.postForEntity(CreateUrl, customerFromLead, Customers.class);
			

			// System.out.println("========================" + answer);

			/// resttemplate post calll to customer api Customers custResponse =
			// System.out.println();

			LeadsToCustomersResponse finalResponse = LeadsToCustomersResponse.builder()
					
					.customers(customerFromLead)

					.message("Lead to customer switch is successful.")
								
					.statusCode("2000")
								
					.build();
								

			return finalResponse;

		}

		return null;
	}

}
