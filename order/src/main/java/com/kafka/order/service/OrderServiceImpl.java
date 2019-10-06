package com.kafka.order.service;

import com.kafka.order.domain.Order;
import com.kafka.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;

	public Order order(Order order) {
		if (order.getOrderLine().size() == 0) {
			throw new IllegalArgumentException("No order lines!");
		}
		Order result = orderRepository.save(order);
		fireOrderCreatedEvent(order);
		return result;
	}

	private void fireOrderCreatedEvent(Order order) {
		kafkaTemplate.send("order", order);
	}

	public double getPrice(long orderId) {
		return orderRepository.findById(orderId).get().totalPrice();
	}

}
