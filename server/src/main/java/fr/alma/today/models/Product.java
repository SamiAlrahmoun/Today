package fr.alma.today.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;


public class Product  {

    private ObjectId id;
    @BsonProperty(value = "product_id")
    private String name;
    private String description;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String createdAt;
    private Integer quantity;
    private double amount;
    //Object used for the Synchroniation
    private boolean locked;

    public Product() {
        this.locked = false;
    }
    public Product(ObjectId productID, String name, String description, double price, Integer quantity){
        this.id = productID;
        this.name= name;
        this.description = description;
        this.amount = price;
        this.quantity = quantity;
        this.locked = false;
    }

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the new password
     */
    public void setId(ObjectId id) {
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

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    /**
     * @param amount the new amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
