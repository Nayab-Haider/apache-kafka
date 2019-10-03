package com.kafka.order.repository;

import com.kafka.order.domain.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findByName(@Param("name") String name);

    double findByPrice(@Param("price") String price);

    List<Item> findByNameContaining(@Param("name") String name);
}
