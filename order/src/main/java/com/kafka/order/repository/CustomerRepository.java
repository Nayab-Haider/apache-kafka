package com.kafka.order.repository;

import com.kafka.order.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByName(@Param("name") String name);

}
