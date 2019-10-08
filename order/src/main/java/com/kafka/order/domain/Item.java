package com.kafka.order.domain;

import com.kafka.order.config.Auditable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Item extends Auditable<String> {

    @Id
    @GeneratedValue
    private Long itemId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    public Item(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Item() {

    }
}
