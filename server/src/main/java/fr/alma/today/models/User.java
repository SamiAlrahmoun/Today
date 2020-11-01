package fr.alma.today.models;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.io.Serializable;

@Document(collection = "Users")
public class User implements Serializable {

    @Id
    private String id;
    private String username;
    private String cardId;
    private String accountId;
    private String email;
    private String password;



    /**
     * @param username the username
     * @param email    the password
     * @param password the password
     */
    public User( String accountId,String cardId,String username, String email, String password) {
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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardID) {
        this.cardId = cardID;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
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


}
