package com.kafka.invoicing.repository;

import com.kafka.invoicing.domain.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {
}
