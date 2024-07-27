package com.eyob.finalProject.LeadsAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Leads {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leadId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String company;
	private String status;
	private String source;
	private CustomFields customFields;

}
