package fr.alma.today;
import document.Product;

public class User implements java.io.Serializable {
    private String id, name, email, password, picture;
    private Product refProduct;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPicture() {
        return picture;
    }

    public String getPassword() {
        return password;
    }

    public Product getRefProduct() {
        return refProduct;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRefProduct(Product refProduct) {
        this.refProduct = refProduct;
    }

}