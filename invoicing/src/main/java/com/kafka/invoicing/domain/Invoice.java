package com.kafka.invoicing.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Invoice {

	@Id
	private long id;

	@Embedded
	private Customer customer;

	private Date updated;

	@Embedded
	private Address billingAddress = new Address();

	@OneToMany(cascade = CascadeType.ALL)
	private List<InvoiceLine> invoiceLine;

	public Invoice() {
		super();
		invoiceLine = new ArrayList<InvoiceLine>();
	}

	public Invoice(long id, Customer customer, Date updated, Address billingAddress, List<InvoiceLine> invoiceLine) {
		super();
		this.id = id;
		this.customer = customer;
		this.updated = updated;
		this.billingAddress = billingAddress;
		this.invoiceLine = invoiceLine;
	}

	@Transient
	public void setOrderLine(List<InvoiceLine> orderLine) {
		this.invoiceLine = orderLine;
	}

	public void addLine(int count, Item item) {
		this.invoiceLine.add(new InvoiceLine(count, item));
	}

	public double totalAmount() {
		return invoiceLine.stream().map((ol) -> ol.getCount() * ol.getItem().getPrice()).reduce(0.0,
				(d1, d2) -> d1 + d2);
	}

	public long getId() {
		return id;
	}
}
