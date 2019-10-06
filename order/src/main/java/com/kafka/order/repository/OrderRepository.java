package com.kafka.order.repository;

import com.kafka.order.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
