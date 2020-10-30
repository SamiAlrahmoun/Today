package service;

import document.Cart;
import document.OrderedProduct;
import document.User;

import java.util.Collection;

public interface CartService {

    Cart getCart(User user);

    void mergeLocalCart(Collection<OrderedProduct> orderedProducts, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
