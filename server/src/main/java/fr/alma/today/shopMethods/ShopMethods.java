package fr.alma.today.shopMethods;

import fr.alma.today.repository.ProductRepository;
import fr.alma.today.repository.UserRepository;

public class ShopMethods {
    private UserRepository userRepository;
    private ProductRepository productRepository;

    //to block of synchronisation
    public void readProduct(String productId){

    }
    // to do block de synchronization
    public boolean buy(){
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
