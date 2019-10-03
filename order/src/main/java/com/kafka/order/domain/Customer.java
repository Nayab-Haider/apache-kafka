package com.kafka.order.domain;



import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Data
public class Customer {

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
}
