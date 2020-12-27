package fr.alma.today.shopMethods;

import com.mongodb.client.MongoDatabase;
import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ShopInterfarce extends Remote {

    public User register(String username, String email, String password) throws RemoteException;;

    public User login(String username, String password) throws RemoteException;

    public Product readProduct(String productId) throws RemoteException;

    public List<Cart> readCart(String cardId) throws RemoteException;

    public  Order buy(String id, String cardId, String Address)throws RemoteException;

    public Cart addToCart(String cartId, String productID) throws RemoteException, InterruptedException;

    public Cart removeFromCart(String cartId, String productID) throws RemoteException;

    public Product EditProduct(String productID,String name,String description, double price, Integer quantity) throws RemoteException;
    public Product addProduct (String productID, String name, String description, double price, Integer quantity) throws RemoteException;;
    public ArrayList<Product> getAllProduct() throws RemoteException;;
    public boolean removeProduct(String productId) throws RemoteException;

    public void lockedCartProduct(List<Product> products) throws RemoteException;

    public void lockedProduct(Product product) throws RemoteException;

    public boolean isLocked (String productId) throws RemoteException;

}
