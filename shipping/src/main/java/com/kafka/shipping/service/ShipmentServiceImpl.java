package com.kafka.shipping.service;

import com.kafka.shipping.domain.Shipment;
import com.kafka.shipping.repository.ShipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final Logger log = LoggerFactory.getLogger(ShipmentServiceImpl.class);

    private ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        super();
        this.shipmentRepository = shipmentRepository;
    }

    @Transactional
    public void ship(Shipment shipment) {
        log.info("Received Shipment");
        log.info(String.valueOf(shipment));
        if (shipmentRepository.existsById(shipment.getId())) {
            log.info("Shipment id {} already exists - ignored", shipment.getId());
        } else {
            shipmentRepository.save(shipment);
        }
    }

}
