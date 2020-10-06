public class Product {
    private String id, name, descriptif, createdAt, quantity, picture;
    private int amount;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public int getAmount() {
        return amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getPicture() {
        return picture;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
