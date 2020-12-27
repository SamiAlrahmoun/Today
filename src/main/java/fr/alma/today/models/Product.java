package fr.alma.today.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import java.util.UUID;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Product  implements Serializable {
    private static final long serialVersionUID = 1L;
    @BsonProperty(value = "product_id")
    private String id;
    private String name;
    private String description;

    private String createdAt;
    private Integer quantity;
    private double amount;
    //Object used for the Synchroniation
    private boolean locked;

    SimpleDateFormat formater = null;

    Date aujourdhui = new Date();


    public Product() {
        this.locked = false;
    }
    public Product(String productID, String name, String description, double price, Integer quantity){
        formater = new SimpleDateFormat("'le' dd MMMM yyyy 'à' hh:mm:ss");
       // System.out.println(formater.format(aujourdhui));

        this.id = generateString(productID);
        this.name= name;
        this.description = description;
        this.amount = price;
        this.quantity = quantity;
        this.locked = false;
        this.createdAt= formater.format(aujourdhui);
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

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    /**
     * @param amount the new amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public static String generateString(String name) {
        String uuid = UUID.randomUUID().toString();
        return name+"-"+ uuid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", locked=" + locked +
                '}';
    }
}
