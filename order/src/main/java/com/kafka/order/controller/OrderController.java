package com.kafka.order.controller;

import com.kafka.order.domain.Customer;
import com.kafka.order.domain.Item;
import com.kafka.order.domain.Order;
import com.kafka.order.repository.CustomerRepository;
import com.kafka.order.repository.ItemRepository;
import com.kafka.order.repository.OrderRepository;
import com.kafka.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;


    @ModelAttribute("items")
    public Iterable<Item> items() {
        return itemRepository.findAll();
    }

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return customerRepository.findAll();
    }

    @RequestMapping("/")
    public ModelAndView orderList() {
        return new ModelAndView("orderlist", "orders", orderRepository.findAll());
    }

    @RequestMapping(value = "/form.html", method = RequestMethod.GET)
    public ModelAndView form() {
        return new ModelAndView("orderForm", "order", new Order());
    }

    @RequestMapping(value = "/line", method = RequestMethod.POST)
    public ModelAndView addLine(Order order) {
        order.addLine(0, itemRepository.findAll().iterator().next());
        return new ModelAndView("orderForm", "order", order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") long id) {
        return new ModelAndView("order", "order", orderRepository.findById(id).get());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView post(Order order) {
        order = orderService.order(order);
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ModelAndView post(@PathVariable("id") long id) {
        orderRepository.deleteById(id);
        return new ModelAndView("success");
    }

}
