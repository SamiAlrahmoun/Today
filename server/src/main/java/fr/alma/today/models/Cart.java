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
    private String cartId;
    private List<Product> products = new ArrayList<Product>() ;
    private Double total ;
    private Integer size ;

    public Cart(){
        this.size = 0;
        this.total = 0.0;
    }


    
    
    
    public List<Product> getItems() {
        return products;
    }
    

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    public Double cartPrice(List<Product> products){
        Double sum = 0.0;
        for (Product product:products) {
            sum += product.getAmount();
        }
        return sum;
    }

    public Double getTotal() {
        return total;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Product> getProducts() {
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
    

}