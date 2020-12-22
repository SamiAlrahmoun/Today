package fr.alma.today.shopMethods;

import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ShopInterfarce extends Remote {

    public User register(String username, String email, String password) throws RemoteException;;

    public User login(String username, String password) throws RemoteException;

    public Product readProduct(Integer productId) throws RemoteException;

    public List<Cart> readCart(Integer cardId) throws RemoteException;

    public Order buy(Integer id, Integer cardId, String Address) throws RemoteException;

    public Cart addToCart(Integer cartId, Integer productID) throws RemoteException;

    public Cart removeFromCart(Integer cartId, Integer productID) throws RemoteException;

    public Product EditProduct(Integer productID,String name,String description, double price, Integer quantity) throws RemoteException;

    public boolean deletProduct(Integer productId) throws RemoteException;

    public void lockedCartProduct(List<Product> products) throws RemoteException;

    public void lockedProduct(Product product) throws RemoteException;

    public boolean isLocked (Integer productId) throws RemoteException;

}
