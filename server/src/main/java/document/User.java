package document;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

@Document
public class User implements java.io.Serializable {

    @Id
    private int id;
    private String username;
    private String email;
    private String password;

    public User() {
    }

    /**
     * @param username the username
     * @param email    the password
     * @param password the password
     */
    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the new password
     */
    public void setId(int id) {
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
