package fr.alma.today.shopMethods;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fr.alma.today.models.*;
import fr.alma.today.repository.CartRepository;
import fr.alma.today.repository.UserRepository;
import fr.alma.today.service.AccountService;
import fr.alma.today.service.CartService;
import fr.alma.today.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AuthMethods {
    private  MongoTemplate mongoTemplate;
    @Autowired
    private  UserRepository userRepo ;
    @Autowired
    private CartRepository cartRepository ;
   // private  CartRepository cartRepository;
    private UserService userService = new UserService();
    private CartService cartService;
    private AccountService accountService;

    private MongoDatabase database;

    public AuthMethods( MongoDatabase database) {
        System.out.println("the data base is initiate");
        this.database = database;
    }


    public User register(String username,String email,String password){
        Cart cart= new Cart(email);
        this.cartService.saveCart(cart, this.database);
        Account account = new Account(username,email);
        this.accountService.saveAccount(account,database);
        User user =  new User(username,email,password);
        return this.userService.saveUser(user,database);
    }
    public User login(String username, String password){
      User client =  this.userService.getCustomerByUsername(username, this.database);
     if(client.getPassword()==password){
         return client;
     }else{
        return client;
     }
    }
}
