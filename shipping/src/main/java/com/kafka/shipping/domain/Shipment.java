package com.kafka.shipping.domain;

import com.kafka.shipping.config.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Shipment extends Auditable<String> {

    @Id
    private long id;

    @Embedded
    private Customer customer;

    @Embedded
    private Address shippingAddress = new Address();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShipmentLine> shipmentLine;

    public Shipment() {
        super();
        shipmentLine = new ArrayList<ShipmentLine>();
    }

    public Shipment(long id, Customer customer, Address shippingAddress,
                    List<ShipmentLine> shipmentLine) {
        super();
        this.id = id;
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.shipmentLine = shipmentLine;
    }


    public Shipment(Customer customer) {
        super();
        this.customer = customer;
        this.shipmentLine = new ArrayList<ShipmentLine>();
    }
}
