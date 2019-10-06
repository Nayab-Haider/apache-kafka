package com.kafka.order.domain;

import com.kafka.order.config.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ORDERTABLE")
public class Order extends Auditable<String> {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Customer customer;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "SHIPPING_STREET")),
            @AttributeOverride(name = "zip", column = @Column(name = "SHIPPING_ZIP")),
            @AttributeOverride(name = "city", column = @Column(name = "SHIPPING_CITY"))})
    private Address shippingAddress = new Address();

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
            @AttributeOverride(name = "zip", column = @Column(name = "BILLING_ZIP")),
            @AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY"))})
    private Address billingAddress = new Address();

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLine;

    public Order() {
        super();
        orderLine = new ArrayList<OrderLine>();
    }

    public Order(Customer customer) {
        super();
        this.customer = customer;
        this.orderLine = new ArrayList<OrderLine>();
    }

    public void addLine(int count, Item item) {
        this.orderLine.add(new OrderLine(count, item));
    }

    public double totalPrice() {
        return orderLine.stream().map((ol) -> ol.getCount() * ol.getItem().getPrice()).reduce(0.0, (d1, d2) -> d1 + d2);
    }

}
