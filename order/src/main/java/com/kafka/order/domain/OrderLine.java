package com.kafka.order.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderLine {

    @Column(name = "F_COUNT")
    private int count;

    @ManyToOne
    private Item item;

    @Id
    @GeneratedValue
    private long id;

    public OrderLine() {
    }

    public OrderLine(int count, Item item) {
        this.count = count;
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public Item getItem() {
        return item;
    }

}
