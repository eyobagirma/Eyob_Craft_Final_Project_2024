package com.eyob.finalProject.OrdersAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eyob.finalProject.OrdersAPI.model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

}

