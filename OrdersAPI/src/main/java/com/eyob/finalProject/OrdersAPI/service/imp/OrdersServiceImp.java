package com.eyob.finalProject.OrdersAPI.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eyob.finalProject.OrdersAPI.dto.Customers;
import com.eyob.finalProject.OrdersAPI.dto.OrdersRequest;
import com.eyob.finalProject.OrdersAPI.dto.OrdersResponse;
import com.eyob.finalProject.OrdersAPI.dto.OrdersUpdateRequest;
import com.eyob.finalProject.OrdersAPI.model.Orders;
import com.eyob.finalProject.OrdersAPI.model.Products;
import com.eyob.finalProject.OrdersAPI.repo.OrdersRepo;
import com.eyob.finalProject.OrdersAPI.service.OrdersService;

@Service
public class OrdersServiceImp implements OrdersService {

	@Autowired
	OrdersRepo ordersRepo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public OrdersResponse createOrder(OrdersRequest ordersRequest) {

		Customers cus = new Customers();
		cus.setCustomerId(ordersRequest.getCustomerId());

		String custFindById = "http://localhost:9091/api/auth/customers/ch1/findCustomerById/";
		Customers customers = restTemplate.getForObject(custFindById + ordersRequest.getCustomerId(), Customers.class);

		if (customers.equals(customers)) {

			double totalSum = 0;

//		for (int i = 0; i <= orders.getProducts().size() - 1; i++) {
//			
//			Products p = orders.getProducts().get(i);
//			
//			totalSum += p.getPrice() * p.getQuantity(); 
//		}

		for (Products p : ordersRequest.getProducts()) {

			totalSum += p.getPrice() * p.getQuantity();
		}

		totalSum = totalSum - ordersRequest.getDiscount();


		// make restTemplate call to get customer

		Orders orders = new Orders();
		
		orders.setProducts(ordersRequest.getProducts());
		orders.setDiscount(ordersRequest.getDiscount());
		orders.setShippingAddress(ordersRequest.getShippingAddress());
		orders.setNotes(ordersRequest.getNotes());

		orders.setCustomers(cus);

		orders.setStatus("Pedning");

		orders.setTotalAmount(totalSum);

//		Orders o = new Orders();
//		int j = orders.getOrderId();
//		o = orders;
//		System.out.println("=========================" + o.getOrderId());
//		System.out.println("=========================" + orders.getOrderId());

		ordersRepo.save(orders);

//		System.out.println("=========================" + o.getOrderId() + "==" + j);
//		System.out.println("=========================" + orders.getOrderId());
//		

		OrdersResponse response = OrdersResponse.builder()

				.orderId(orders.getOrderId())

				.customerId(ordersRequest.getCustomerId())

				.products(ordersRequest.getProducts())

				.totalAmount(totalSum)

				.status(orders.getStatus())

				.discount(ordersRequest.getDiscount())

				.shippingAddress(ordersRequest.getShippingAddress())

				.notes(ordersRequest.getNotes())

				.message("Order created successfully.")

				.statusCode("1000")

				.build();

		return response;

	} else {

		OrdersResponse response = OrdersResponse.builder()

				.message("Customer not found!! Order creation not complete!!")

				.statusCode("888")

				.build();

		return response;
	}

	}

	@Override
	public OrdersResponse updateOrder(OrdersUpdateRequest ordersUpdateRequest) {

		Optional<Orders> optional = ordersRepo.findById(ordersUpdateRequest.getOrderId());

		if (optional.isPresent()) {

			double totalSum = 0;

			Orders orders = optional.get();

			orders.setProducts(ordersUpdateRequest.getProducts());
			orders.setDiscount(ordersUpdateRequest.getDiscount());
			orders.setStatus(ordersUpdateRequest.getStatus());
			orders.setShippingAddress(ordersUpdateRequest.getShippingAddress());
			orders.setNotes(ordersUpdateRequest.getNotes());

			for (Products p : orders.getProducts()) {
				totalSum += p.getQuantity() * p.getPrice();
			}
			
			totalSum = totalSum - orders.getDiscount();
			
			orders.setTotalAmount(totalSum);
			
			ordersRepo.save(orders);
			
			
			OrdersResponse response = OrdersResponse.builder()

					.orderId(orders.getOrderId())

					.customerId(ordersUpdateRequest.getCustomerId())

					.products(ordersUpdateRequest.getProducts())

					.totalAmount(totalSum)

					.status(orders.getStatus())

					.discount(ordersUpdateRequest.getDiscount())

					.shippingAddress(ordersUpdateRequest.getShippingAddress())

					.notes(ordersUpdateRequest.getNotes())

					.message("Order updated successfully.")

					.statusCode("1000")

					.build();
			
			return response;

		}
		OrdersResponse response = OrdersResponse.builder()

				.message("ERROR:There is no order in the system!!")

				.statusCode("888")

				.build();

		return response;
	}

	@Override
	public OrdersResponse retrieveOrder(int orderId) {

		Optional<Orders> optional = ordersRepo.findById(orderId);

		if (optional.isPresent()) {

			Orders orders = optional.get();

			OrdersResponse response = OrdersResponse.builder()

					.orderId(orders.getOrderId())

					.customerId(orders.getCustomers().getCustomerId())

					.products(orders.getProducts())

					.totalAmount(orders.getTotalAmount())

					.status(orders.getStatus())

					.discount(orders.getDiscount())

					.shippingAddress(orders.getShippingAddress())

					.notes(orders.getNotes())

					.message("Order updated successfully.")

					.statusCode("1000")

					.build();

			return response;

		}

		OrdersResponse response = OrdersResponse.builder()

				.message("ERROR: Order not found!!")

				.statusCode("888")

				.build();

		return response;
	}

}
