package com.kafka.invoicing.domain;

import javax.persistence.*;

@Entity
public class InvoiceLine {

	@Column(name = "F_COUNT")
	private int count;

	@Embedded
	private Item item;

	@Id
	@GeneratedValue
	private long id;

	public void setCount(int count) {
		this.count = count;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public InvoiceLine() {
	}

	public InvoiceLine(int count, Item item) {
		this.count = count;
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public Item getItem() {
		return item;
	}

	public double totalAmount() {
		return getCount() * getItem().getPrice();
	}


}
