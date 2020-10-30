package fr.alma.today.shopMethods;
import fr.alma.today.models.*;
import fr.alma.today.repository.UserRepository;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AuthMethods {
    private  MongoTemplate mongoTemplate;
    private  userRepo = new UserRepository();
    public User register(String username,String email,String password){
        User user =  new User(username,email,password);

        return user;
    }
    public Boolean login(String username, String Password){
        return true;
    }

}
