package fr.alma.today.shopMethods;

import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.repository.CartRepository;
import fr.alma.today.repository.ProductRepository;
import fr.alma.today.repository.UserRepository;
import fr.alma.today.service.CartService;
import fr.alma.today.service.OrderService;
import fr.alma.today.service.ProductService;
import fr.alma.today.service.UserService;

import java.util.List;

public class ShopMethods {

    private ProductService productService = new ProductService();
    private CartService cartService = new CartService();
    private OrderService orderService = new OrderService();



    //to block of synchronisation
    public Product readProduct(String productId){
       return productService.getProductById(productId);
    }
    //to block of synchronisation
    public List<Cart> readCart(String cardId){
        return cartService.mCart(cardId);
    }
    // to do block de synchronization
    public synchronized Order buy(String id, String cardId, String Address){
        ///after the block of  synchronisation
        return orderService.buy(id,cardId,Address);

    }


    //to do block of sybchromisation
    public Cart addToCart(String cartId, String productID){
        return   cartService.addToCart(cartId, productID);

    }
    public synchronized Cart removeFromCart(String cartId, String productID){
        return   cartService.removeToCart(cartId, productID);


    }
    //block of synchronisation
    public synchronized Product EditProduct(String productID,String name,String description, double price, Integer quantity){
        Product product = new Product(productID,name,description,price,quantity);
        return productService.modifyProduct(product);


    }

    //block of synchronisation
    public synchronized boolean deletProduct(String productId){
        return productService.deleteProduct(productId);
    }



}
