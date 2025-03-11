package org.ies.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OrderItem {
    private int productId;
    private int amount;

}
