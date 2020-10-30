package fr.alma.today.shopMethods;
import fr.alma.today.models.*;

public class AuthMethods {

    public User register(String username,String email,String password){
        User user =  new User(username,email,password);
        return user;
    }
    public Boolean login(String username, String Password){

        return true;
    }

}
