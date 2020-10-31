package fr.alma.today.service;



import fr.alma.today.models.Cart;
import fr.alma.today.models.OrderedProduct;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;
import fr.alma.today.repository.CartRepository;

import java.util.Collection;
import java.util.List;

public class CartService {
private CartRepository cartRepository;

    public List<Product> myCart(String product){
        return cartRepository;
    }
    public void mergeLocalCart(Collection<OrderedProduct> orderedProducts, User user) {

    }

    public void delete(String itemId, User user) {

    }

    public void checkout(User user) {

    }
}
