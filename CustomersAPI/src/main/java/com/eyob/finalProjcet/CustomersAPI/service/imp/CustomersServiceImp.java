package com.eyob.finalProjcet.CustomersAPI.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyob.finalProjcet.CustomersAPI.dto.CustomersResponse;
import com.eyob.finalProjcet.CustomersAPI.model.Customers;
import com.eyob.finalProjcet.CustomersAPI.model.repo.CustomersRepo;
import com.eyob.finalProjcet.CustomersAPI.service.CustomersService;

@Service
public class CustomersServiceImp implements CustomersService {

	@Autowired
	CustomersRepo customersRepo;


	@Override
	public CustomersResponse createNewCustomer(Customers customers) {

		try {
			customersRepo.save(customers);

			CustomersResponse response = CustomersResponse.builder()

					.customers(customers)

					.message("Customer registeration is done.")

					.statuscode("1000")

					.build();

			return response;

		} catch (Exception e) {

			CustomersResponse response = CustomersResponse.builder()

					.message("Registeration not complete!!")

					.statuscode("555")

					.build();

			return response;

		}


	}


	@Override
	public CustomersResponse updateExistingCustomer(int customerId, Customers customers) {

		Optional<Customers> optional = customersRepo.findById(customerId);

		try {

			if (optional.isPresent()) {

				Customers customersAlt = optional.get();

				customersAlt.setFirstName(customers.getFirstName());
				customersAlt.setLastName(customers.getLastName());
				customersAlt.setEmail(customers.getEmail());
				customersAlt.setPhone(customers.getPhone());
				customersAlt.setAddress(customers.getAddress());
				customersAlt.setNotes(customers.getNotes());
				customersAlt.setCustomFields(customers.getCustomFields());

				customersRepo.save(customersAlt);

				CustomersResponse response = CustomersResponse.builder()

						.customers(customersAlt)

						.message("Customer has been updated.")

						.statuscode("1000")

						.build();

				return response;
			}

		} catch (Exception e) {

			CustomersResponse response = CustomersResponse.builder()

					.message("Error: No update has been done!")

					.statuscode("999")

					.build();

			return response;

		}

		return null;
	}


	@Override
	public CustomersResponse findByCustomerId(int customerId) {

		Optional<Customers> optional = customersRepo.findById(customerId);

			if (optional.isPresent()) {

				optional.get();

				CustomersResponse response = CustomersResponse.builder()

						.customers(optional.get())

						.message("Customer found in the system.")

						.statuscode("1000")

						.build();

				return response;
			}

			else {

			CustomersResponse response = CustomersResponse.builder()

					.message("Customer not found in the system!!")

					.statuscode("888")

					.build();

				return response;
		}


	}

}
