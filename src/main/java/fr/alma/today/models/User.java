package fr.alma.today.models;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @BsonProperty(value = "user_id")
    private ObjectId id;
    @BsonProperty(value = "card_id")
    private ObjectId cardId;
    @BsonProperty(value = "username")
    private String username;
    @BsonProperty(value = "account_id")
    private ObjectId accountId;

    private String email;
    private String password;



    /**
     * @param username the username
     * @param email    the password
     * @param password the password
     */
    public User(String username, String email, String password) {
        this.accountId = accountId;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User(ObjectId accountId, ObjectId cardId, String username, String email, String password) {
        this.cardId = cardId;
        this.accountId = accountId;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User() {

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the new password
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the new password
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public ObjectId getCardId() {
        return cardId;
    }

    public void setCardId(ObjectId cardID) {
        this.cardId = cardID;
    }

    public ObjectId getAccountId() {
        return accountId;
    }

    public void setAccountId(ObjectId accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", cardId=" + cardId +
                ", username='" + username + '\'' +
                ", accountId=" + accountId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
