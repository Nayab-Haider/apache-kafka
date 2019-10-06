package com.kafka.order.service;

import com.kafka.order.domain.Order;
import com.kafka.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepository;

	private KafkaTemplate<String, Order> kafkaTemplate;

	@Autowired
	private OrderServiceImpl(OrderRepository orderRepository, KafkaTemplate<String, Order> kafkaTemplate) {
		super();
		this.orderRepository = orderRepository;
		this.kafkaTemplate = kafkaTemplate;
	}

	public Order order(Order order) {
		if (order.getOrderLine().size() == 0) {
			throw new IllegalArgumentException("No order lines!");
		}
		order.setUpdated(new Date());
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
