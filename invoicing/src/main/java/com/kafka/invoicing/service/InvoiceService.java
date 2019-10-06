package com.kafka.invoicing.service;

import com.kafka.invoicing.domain.Invoice;

public interface InvoiceService {
    public void generateInvoice(Invoice invoice);
}
