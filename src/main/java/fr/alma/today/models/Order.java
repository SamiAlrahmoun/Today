package fr.alma.today.models;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public class Order  implements Serializable {
    private static final long serialVersionUID = -3819883511505235030L;
    @BsonProperty(value = "order_id")
    private String id;

    /*private Set<ProductInOrder> products = new HashSet<>();*/
    private String username;
    private String email;
    private String address;
    private List<Product> products;
    private Double price;
    private Integer quantity;


    public Order() {

    }
    public Order (String username,String email, String address, List<Product> products, Double price, Integer quantity){
        this.id = generateString(username);
        this.username =username;
        this.email =  email;
        this.address = address;
        this.products = products;
        this.price = price;
        this.quantity = quantity;

    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
    public static String generateString(String name) {
        String uuid = UUID.randomUUID().toString();
        return name+"-"+ uuid;
    }
}

