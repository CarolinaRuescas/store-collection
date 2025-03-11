package org.ies.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor

public class Product {
    private int id;
    private String name;
    private double price;
    private Set<String > tags;
}
