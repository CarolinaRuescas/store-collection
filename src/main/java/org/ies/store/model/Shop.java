package org.ies.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.TreeSet;

@Data
@AllArgsConstructor

public class Shop {
    private String name;
    private Map<Integer, Product> productsById;
    private TreeSet<Customer> customers;
}
