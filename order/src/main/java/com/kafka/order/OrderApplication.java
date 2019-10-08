package com.kafka.order;

import com.kafka.order.domain.Customer;
import com.kafka.order.domain.Item;
import com.kafka.order.repository.CustomerRepository;
import com.kafka.order.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.save(new Item("iPod", 42.0));
        itemRepository.save(new Item("iPod touch", 21.0));
        itemRepository.save(new Item("iPod nano", 1.0));
        itemRepository.save(new Item("Apple TV", 100.0));

        customerRepository
                .save(new Customer("Eberhard", "Wolff", "eberhard.wolff@gmail.com", "Unter den Linden", "Berlin"));
        customerRepository.save(new Customer("Rod", "Johnson", "rod@somewhere.com", "Market Street", "San Francisco"));

    }
}
