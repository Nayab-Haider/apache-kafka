package com.kafka.order.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue
    private Long itemId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;
}
