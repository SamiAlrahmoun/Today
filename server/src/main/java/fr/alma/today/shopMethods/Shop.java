package fr.alma.today.shopMethods;

import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;

import java.util.List;

public interface Shop {

    public Product readProduct(String productId);

    public List<Cart> readCart(String cardId);

    public Order buy(String id, String cardId, String Address);

    public Cart addToCart(String cartId, String productID);

    public Cart removeFromCart(String cartId, String productID);

    public Product EditProduct(String productID,String name,String description, double price, Integer quantity);

    public boolean deletProduct(String productId);

    public void lockedCartProduct(List<Product> products);

    public void lockedProduct(Product product);

    public boolean isLocked (String productId);

}
