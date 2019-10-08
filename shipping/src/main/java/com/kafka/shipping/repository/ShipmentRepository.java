package com.kafka.shipping.repository;

import com.kafka.shipping.domain.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Long> {
}
