package fr.alma.today.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document

public class Cart implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;
    private User user;

    private List<Product> items = new ArrayList<Product>() ;

    public List<Product> getItems() {
        return items;
    }

    public void addToCart(Product item){
        this.items.add(item);
    }

    public void removeToCArt(Product item){
        this.items.removeIf(prod->prod.getId()==item.getId());
    }
    public void removeAll(){
        this.getItems().clear();
    }
    private Set<OrderedProduct> products = new HashSet<>();

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", products=" + products +
                '}';
    }

    public Cart(User user) {
        this.user = user;
    }

}