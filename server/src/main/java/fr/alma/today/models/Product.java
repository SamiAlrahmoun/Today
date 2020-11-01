package fr.alma.today.models;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Document(collection = "Products")
public class Product implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String createdAt;
    private Integer quantity;
    private double amount;

    public Product() {
    }
    public Product(String productID,String name,String description, double price, Integer quantity){
        this.id = productID;
        this.name= name;
        this.description = description;
        this.amount = price;
        this.quantity = quantity;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the new password
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the new password
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the new password
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the new password
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the Quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity  set the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the new password
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
