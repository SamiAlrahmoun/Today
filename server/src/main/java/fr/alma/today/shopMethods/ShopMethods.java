package fr.alma.today.shopMethods;

import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;
import fr.alma.today.repository.CartRepository;
import fr.alma.today.repository.ProductRepository;
import fr.alma.today.service.CartService;
import fr.alma.today.service.OrderService;
import fr.alma.today.service.ProductService;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ShopMethods extends UnicastRemoteObject implements ShopInterfarce {

    private ProductService productService; // = new ProductService();
    private CartService cartService ;// = new CartService();
    private OrderService orderService;// = new OrderService();
    private MongoDatabase database;
    private AuthMethods auth;
    public ShopMethods(MongoDatabase database) throws RemoteException {
        super();
        this.database = database;
        this.auth =  new AuthMethods(database);
    }


    public User login(String username, String password){
       return this.auth.login(username,password);
    }


    public User register(String username, String email, String password){
        System.out.println(username+" Called register");
        return this.auth.register(username,email,password);
    }



    //to block of synchronisation
    public Product readProduct(Integer productId){
       return productService.getProductById(productId);
    }
    //to block of synchronisation
    public List<Cart> readCart(Integer cardId){
        return cartService.mCart(cardId);
    }
    // to do block de synchronization
    public synchronized Order buy(Integer id, Integer cardId, String Address){
        this.database.getCollection("Cart").find(Filters.eq("_id", cardId)).first().toJson();
     Cart cart=  new Cart() ;
        // cart = cartRepository.findCartByCartId(cardId);
        lockedCartProduct(cart.getProducts());
        ///after the block of  synchronisation
        return orderService.buy(id,cardId,Address);

    }


    //to do block of sybchromisation
    public Cart addToCart(Integer cartId, Integer productID){
        return   cartService.addToCart(cartId, productID);

    }
    public synchronized Cart removeFromCart(String cartId, Integer productID){
        if(isLocked(productID)){
            return cartService.getCart(cartId, this.database);
        }else{
            return cartService.removeToCart(cartId, productID);
        }

    }
    //block of synchronisation
    public synchronized Product EditProduct(Integer productID,String name,String description, double price, Integer quantity){
        if(isLocked(productID)){
            return productService.getProductById(productID);
        }else{
            Product product = new Product(productID,name,description,price,quantity);
            return productService.modifyProduct(product);
        }
    }

    //block of synchronisation
    public synchronized boolean deletProduct(Integer productId){
        if(isLocked(productId)){
            return productService.deleteProduct(productId);
        }else{
            return false;
        }

    }

   public void lockedCartProduct(List<Product> products){
       for (Product product:products) {
           lockedProduct(product);
       }
   }
   public void lockedProduct(Product product){
       product.setLocked(true);
       productRepository.save(product);
   }
   public boolean isLocked (Integer productId){
      return   productRepository.findProductById(productId).isLocked();
   }

}
