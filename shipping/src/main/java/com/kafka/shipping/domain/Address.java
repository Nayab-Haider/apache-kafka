package com.kafka.shipping.domain;

import com.kafka.shipping.config.Auditable;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

	private String street;
	private String zip;
	private String city;

	public Address() {
		super();
	}

	public Address(String street, String zip, String city) {
		super();
		this.street = street;
		this.zip = zip;
		this.city = city;
	}
}
