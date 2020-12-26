package fr.alma.today.models;
import org.bson.codecs.pojo.annotations.BsonProperty;
import java.io.Serializable;
public class Account implements Serializable{
    private static final long serialVersionUID = 1L;
    @BsonProperty(value = "user_id")
    private String id;

    private boolean status;
    private String name;
    private Double amount;

    public Account(String  name,String email) {
        this.name = name;
        this.id = email;
        this.status = true;
        this.amount = freeAmount();

    }

    public Account(String id, boolean closed) {
        this.id = id;
        this.status = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isClosed() {
        return status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public String getName() {
        return name;
    }
    public Double freeAmount(){
        double amount = (double) (Math.random() * (3000 - 1000)) + 1000;
        return amount;
    }
}
