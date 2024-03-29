package com.kafka.order.domain;

import com.kafka.order.config.Auditable;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderLine extends Auditable<String>{

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

}
