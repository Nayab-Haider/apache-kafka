package com.kafka.shipping.service;

import com.kafka.shipping.domain.Shipment;

public interface ShipmentService {
    public void ship(Shipment shipment);
}
