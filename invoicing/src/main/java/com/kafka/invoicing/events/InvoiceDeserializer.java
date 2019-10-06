package com.kafka.invoicing.events;

import com.kafka.invoicing.domain.Invoice;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class InvoiceDeserializer extends JsonDeserializer<Invoice> {

	public InvoiceDeserializer() {
		super(Invoice.class);
	}

}
