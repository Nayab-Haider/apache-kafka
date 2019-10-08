package com.kafka.shipping.domain;

import com.kafka.shipping.config.Auditable;

import javax.persistence.*;

@Entity
public class ShipmentLine extends Auditable<String> {

    @Column(name = "F_COUNT")
    private int count;

    @Embedded
    private Item item;

    @Id
    @GeneratedValue
    private long id;

    public ShipmentLine() {
    }

    public ShipmentLine(int count, Item item) {
        this.count = count;
        this.item = item;
    }
}
