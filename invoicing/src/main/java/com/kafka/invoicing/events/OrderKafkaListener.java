package com.kafka.invoicing.events;

import com.kafka.invoicing.domain.Invoice;
import com.kafka.invoicing.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OrderKafkaListener {

	private final Logger log = LoggerFactory.getLogger(OrderKafkaListener.class);

	private InvoiceService invoiceService;

	public OrderKafkaListener(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}

	@KafkaListener(topics = "order")
	public void order(Invoice invoice, Acknowledgment acknowledgment) {
		log.info("Received invoice ");
		invoiceService.generateInvoice(invoice);
		acknowledgment.acknowledge();
	}

}
