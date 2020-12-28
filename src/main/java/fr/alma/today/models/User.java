package fr.alma.today.models;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @BsonProperty(value = "user_id")
    private String id;

    @BsonProperty(value = "username")
    private String username;

    private String email;
    private String password;



    /**
     * @param username the username
     * @param email    the email
     * @param password the password
     */
    public User(String username, String email, String password) {
        this.id = email;
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
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
