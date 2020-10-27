package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @Column(unique = true, nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String createdAt;
    @Column(nullable = false)
    private String quantity;
    @Column(nullable = false)
    private int amount;

    public Product() {
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
    public String getQuantity() {
        return quantity;
    }
    /**
     * @param quantity the new password
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }
    /**
     * @param amount the new password
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
