package fr.alma.today.shopMethods;

import fr.alma.today.models.User;

public interface Auth {

    public User register(String username, String email, String password);

    public User login(String username, String password);

}
