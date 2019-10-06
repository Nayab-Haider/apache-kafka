package com.kafka.invoicing.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
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
