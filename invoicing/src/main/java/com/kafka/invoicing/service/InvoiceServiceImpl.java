package com.kafka.invoicing.service;

import com.kafka.invoicing.domain.Invoice;
import com.kafka.invoicing.repository.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final Logger log = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Transactional
    public void generateInvoice(Invoice invoice) {
        log.info("Received invoice:--");
        log.info(String.valueOf(invoice));
        if (invoiceRepository.existsById(invoice.getId())) {
            log.info("Invoice id {} already exists - ignored", invoice.getId());
        } else {
            invoiceRepository.save(invoice);
        }
    }

}
