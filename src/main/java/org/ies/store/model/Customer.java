package org.ies.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class Customer implements Comparable<Customer>{
    private String nif;
    private String name;
    private String surname;
    private List<Order> orders;


    @Override
    public int compareTo(Customer customer) {
        int compare = this.surname.compareTo(customer.surname);
        if (compare == 0){
            compare = this.name.compareTo(customer.name);
            if (compare == 0){
                compare = this.nif.compareTo(customer.nif);
            }
        }
        return compare;
    }
}
