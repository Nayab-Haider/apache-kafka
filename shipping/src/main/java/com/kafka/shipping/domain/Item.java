package com.kafka.shipping.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Item {

    private Long itemId;

    private String name;

    public Item() {
        super();
        itemId = 0l;
    }
}
