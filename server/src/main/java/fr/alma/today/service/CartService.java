package fr.alma.today.service;



import fr.alma.today.models.Cart;
import fr.alma.today.models.OrderedProduct;
import fr.alma.today.models.User;

import java.util.Collection;

public interface CartService {

    Cart getCart(User user);

    void mergeLocalCart(Collection<OrderedProduct> orderedProducts, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
