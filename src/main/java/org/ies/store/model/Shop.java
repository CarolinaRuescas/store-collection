package org.ies.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Data
@AllArgsConstructor

public class Shop {
    private String name;
    private Map<Integer, Product> productsById;
    private TreeSet<Customer> customers;


    // Dado un nif, devuelve el cliente con ese NIF.
    public Customer findCustomer(String nif){
        for (var customer: customers) {
            if(customer.getNif().equals(nif)) {
                return customer;
            }
        }
        return null;
    }

    // Dado un nif y un id de pedido, devuelve el pedido del cliente.
    public Order findOrder(String nif, int orderId) {
        var customer = findCustomer(nif);
        if(customer != null) {
            return customer.findOrder(orderId);
        } else {
            return null;
        }
    }

    //Dado un id de producto, devuelve el producto con ese id
    public Product productId(int id){
        for(var product : productsById.values()){
            if (product.getId()== id){
                return product;
            }
        }
        return null;
    }

    // Dado un nif y un id de pedido, devuelve una lista con los productos que se han pedido.
    public List<Product> findOrderProduct(String nif, int orderId){
        Order order = findOrder(nif, orderId);
        if(order != null){
            List<Product> products = new ArrayList<>();
            for(var item : order.getOrderItems()){
                Product product = productsById.get(item.getProductId());
                products.add(product);
            }
            return products;
        }else {
            return null;
        }
    }

    // Dado un nif, devuelve cuánto se ha gastado el cliente en la tienda.
    public Double spentByCustomer(String nif){
        var customer = findCustomer(nif);
        if(customer != null){
            return customer.spent();
        }else{
            return null;
        }
    }




}
