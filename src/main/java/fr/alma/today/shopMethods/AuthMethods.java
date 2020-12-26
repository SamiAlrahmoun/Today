package fr.alma.today.shopMethods;
import com.mongodb.client.MongoDatabase;
import fr.alma.today.models.*;

import fr.alma.today.service.AccountService;
import fr.alma.today.service.CartService;
import fr.alma.today.service.UserService;


public class AuthMethods {


   // private  CartRepository cartRepository;
    private final UserService userService = new UserService();
    private final CartService cartService = new CartService();
    private final AccountService accountService = new AccountService();

    private final MongoDatabase database;

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
        System.out.println("password database :"+client.getPassword());
        System.out.println("password :"+password);
     if(client.getPassword().equals(password)){
         System.out.println("login succes");
         return client;
     }else{
         System.out.println("login failed");
        return null;
     }
    }
}
