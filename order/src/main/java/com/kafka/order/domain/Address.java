package com.kafka.order.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

	private String street;
	private String zip;
	private String city;
}
