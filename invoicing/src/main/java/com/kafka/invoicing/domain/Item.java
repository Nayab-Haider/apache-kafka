package com.kafka.invoicing.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Item {

    @Column(nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    public Item() {
        super();
        itemId = 0l;
    }

    public Item(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
