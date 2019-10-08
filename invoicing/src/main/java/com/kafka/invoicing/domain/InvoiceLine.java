package com.kafka.invoicing.domain;

import com.kafka.invoicing.config.Auditable;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class InvoiceLine extends Auditable<String> {

	@Column(name = "F_COUNT")
	private int count;

	@Embedded
	private Item item;

	@Id
	@GeneratedValue
	private long id;

	public InvoiceLine() {
	}

	public InvoiceLine(int count, Item item) {
		this.count = count;
		this.item = item;
	}

	public double totalAmount() {
		return getCount() * getItem().getPrice();
	}


}
