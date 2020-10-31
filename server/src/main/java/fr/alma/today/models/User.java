package fr.alma.today.models;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

@Document(collection = "Users")
public class User implements java.io.Serializable {

    @Id
    private String id;
    private String username;
    private String cardID;
    private String email;
    private String password;


    /**
     * @param username the username
     * @param email    the password
     * @param password the password
     */
    public User( String id,String username, String email, String password) {
        this.cardID = id;
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

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    /**
     * @return the email
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
