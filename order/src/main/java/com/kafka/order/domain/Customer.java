package com.kafka.order.domain;



import com.kafka.order.config.Auditable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Data
public class Customer extends Auditable<String> {

	@Id
	@GeneratedValue
	private Long customerId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	@Email
	private String email;

	public Customer(String firstname, String name, String email, String street, String city) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.email = email;
	}

	public Customer(){

	}
}
