package fr.alma.today.shopMethods;

import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;

import fr.alma.today.service.CartService;
import fr.alma.today.service.OrderService;
import fr.alma.today.service.ProductService;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ShopMethods extends UnicastRemoteObject implements ShopInterfarce {

    private ProductService productService = new ProductService();
    private CartService cartService = new CartService();
    private OrderService orderService = new OrderService();
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
    public Product readProduct(String productId){
       return productService.getProduct(productId, this.database );
    }
    //to block of synchronisation
    public List<Cart> readCart(String cardId){
        return (List<Cart>) cartService.getCart(cardId, this.database);
    }



    public synchronized Order buy(String id, String cardId, String Address)throws RemoteException{

        Cart cart  =  cartService.getCart(cardId,this.database);

        // cart = cartRepository.findCartByCartId(cardId);
        lockedCartProduct(cart.getProducts());
        ///after the block of  synchronisation
        return orderService.buy(id,cardId,Address,this.database);

    }


    //to do block of sybchromisation
    public Cart addToCart(String cartId, String productID){
        return   cartService.addToCart(cartId, productID, this.database);

    }
    public synchronized Cart removeFromCart(String cartId, String productID){
        if(isLocked(productID)){
            return cartService.getCart(cartId, this.database);
        }else{
            return cartService.removeToCart(cartId, productID, this.database);
        }

    }

    public Product addProduct (String productID, String name, String description, double price, Integer quantity){
        Product product = new Product(productID,name,description,price, quantity);
    this.productService.saveProduct(product,this.database);
    return product;
    }

    //block of synchronisation
    public synchronized Product EditProduct(String productID,String name,String description, double price, Integer quantity){

        if(isLocked(productID)){
            return null;
        }else{

            Product product = new Product(productID,name,description,price,quantity);
            product.setId(productID);
            return productService.modifyProduct(product, database);
        }
    }

    public ArrayList<Product> getAllProduct(){
      return (ArrayList<Product>) productService.getProductList(this.database);
    }

    //block of synchronisation
    public synchronized boolean removeProduct(String productId) throws RemoteException{
        if(isLocked(productId)){
            return productService.deleteProduct(productId,this.database );
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
       productService.modifyProduct(product,this.database);
   }
   public boolean isLocked (String productId){
      return   productService.getProduct(productId,this.database).isLocked();
   }

}
