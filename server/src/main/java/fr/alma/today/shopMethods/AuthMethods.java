package fr.alma.today.shopMethods;
import com.mongodb.client.MongoDatabase;
import fr.alma.today.models.*;

import fr.alma.today.service.AccountService;
import fr.alma.today.service.CartService;
import fr.alma.today.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthMethods {


   // private  CartRepository cartRepository;
    private UserService userService = new UserService();
    private CartService cartService = new CartService();
    private AccountService accountService = new AccountService();

    private MongoDatabase database;

    public AuthMethods( MongoDatabase database) {
        System.out.println("the data base is initiate");
        this.database = database;
    }


    public User register(String username,String email,String password){
        Cart cart= new Cart(email);
        System.out.println(this.database);
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
