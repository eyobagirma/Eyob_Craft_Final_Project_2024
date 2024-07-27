package com.eyob.finalProject.LeadsAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyob.finalProject.LeadsAPI.dto.LeadConversion;
import com.eyob.finalProject.LeadsAPI.dto.LeadsToCustomersResponse;
import com.eyob.finalProject.LeadsAPI.model.Leads;
import com.eyob.finalProject.LeadsAPI.service.LeadsService;

@RestController
@RequestMapping("/api/auth/leads/ch2")
public class LeadsController {

	@Autowired
	LeadsService leadsService;

	@PostMapping("/createLead")
	public ResponseEntity<?> createLead(@RequestBody Leads leads) {
	
		return new ResponseEntity<>(leadsService.createLeads(leads), HttpStatus.CREATED);
	}

	@PutMapping("/convertLeads/")
	public ResponseEntity<?> convertLeads(@RequestBody LeadConversion input) {

		
		LeadsToCustomersResponse response = leadsService.convertLeads(input.getAddress(), input.getCustomFields(),
				input.getNotes(), input.getLeadId());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
