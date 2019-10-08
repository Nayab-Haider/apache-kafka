package com.kafka.shipping.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Customer {

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstname;

    public Customer() {
        super();
        customerId = 0l;
    }

    public Customer(long customerId, String firstname, String name) {
        super();
        this.customerId = customerId;
        this.name = name;
        this.firstname = firstname;
    }
}
