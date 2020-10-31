package fr.alma.today.shopMethods;

import fr.alma.today.models.Product;
import fr.alma.today.repository.ProductRepository;
import fr.alma.today.repository.UserRepository;
import fr.alma.today.service.ProductService;
import fr.alma.today.service.UserService;

public class ShopMethods {
    private UserService userService = new UserService();
    private ProductService productService = new ProductService();

    //to block of synchronisation
    public Product readProduct(String productId){
       return productService.getProductById(productId);
    }
    // to do block de synchronization
    public boolean buy(String username,String productId){

        return true;
    }
    //to do block of sybchromisation
    public void addToCart(String username, String productID){

    }
    public void removeFromCart(String username, String productID){

    }
    //block of synchronisation
    public void EditProduct(String productID){
    }

    //block of synchronisation
    public void deletProduct(String productId){

    }



}
