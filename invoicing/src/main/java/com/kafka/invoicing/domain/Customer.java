package com.kafka.invoicing.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;

@Embeddable
@Data
public class Customer {

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    @Email
    private String email;

    public Customer() {
        super();
        customerId = 0l;
    }

    public Customer(long customerId, String firstname, String name, String email) {
        super();
        this.customerId = customerId;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
    }
}
