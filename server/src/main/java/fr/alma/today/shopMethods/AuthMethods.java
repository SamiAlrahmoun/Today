package fr.alma.today.shopMethods;
import fr.alma.today.models.*;
import fr.alma.today.repository.CartRepository;
import fr.alma.today.repository.UserRepository;
import fr.alma.today.service.CartService;
import fr.alma.today.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AuthMethods {
    private  MongoTemplate mongoTemplate;
    private  UserRepository userRepo ;
    private  CartRepository cartRepository;
    private UserService userService = new UserService();
    private CartService cartService = new CartService();
    public User register(String username,String email,String password){
        Cart cart= new Cart();
          cart = cartRepository.save(cart);
        User user =  new User(cartService.getCart(cart.getCartId()).getCartId(),username,email,password);
        userRepo.save(user);
        return user;
    }
    public Boolean login(String username, String password){
      User client =  this.userService.getCustomerByUsername(username);
     if(client.getPassword()==password){
         return true;
     }else{
        return false;
     }
    }
}
