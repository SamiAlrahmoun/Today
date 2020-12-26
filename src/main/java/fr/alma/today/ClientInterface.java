package fr.alma.today;

import fr.alma.today.models.User;

public interface ClientInterface {
    User getUser(String username, String passs);

}
