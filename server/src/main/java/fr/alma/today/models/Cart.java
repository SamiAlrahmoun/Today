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

    private List<Product> products = new ArrayList<Product>() ;

    public List<Product> getItems() {
        return products;
    }

    public void addToCart(Product item){
        this.products.add(item);
    }

    public void removeToCArt(Product item){
        this.products.removeIf(prod->prod.getId()==item.getId());
    }
    public void removeAll(){
        this.getItems().clear();
    }


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