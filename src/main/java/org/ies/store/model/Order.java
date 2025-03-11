package org.ies.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private LocalDate date;
    private double price;
    private List<OrderItem> orderItems;
}
