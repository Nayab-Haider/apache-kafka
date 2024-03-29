package com.kafka.shipping.events;

import com.kafka.shipping.domain.Shipment;
import com.kafka.shipping.service.ShipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaListener {

	private final Logger log = LoggerFactory.getLogger(OrderKafkaListener.class);

	private ShipmentService shipmentService;

	public OrderKafkaListener(ShipmentService shipmentService) {
		super();
		this.shipmentService = shipmentService;
	}

	@KafkaListener(topics = "order")
	public void order(Shipment shipment, Acknowledgment acknowledgment) {
		log.info("Received shipment ");
		shipmentService.ship(shipment);
		acknowledgment.acknowledge();
	}

}
