package com.eyob.finalProjcet.CustomersAPI.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyob.finalProjcet.CustomersAPI.model.Customers;

@Repository
public interface CustomersRepo extends JpaRepository<Customers, Integer> {

}
