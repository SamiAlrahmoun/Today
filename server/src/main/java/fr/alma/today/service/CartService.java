package fr.alma.today.service;



import fr.alma.today.models.Cart;
import fr.alma.today.models.OrderedProduct;
import fr.alma.today.models.User;
import fr.alma.today.repository.CartRepository;

import javax.smartcardio.Card;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CartService {
private CartRepository cartRepository;

    public Cart myCart(String cardId){
        return cartRepository.findById(cardId);
    }
    public List<Cart> mCart(String cardId){
        return cartRepository.findAll(cardId);
    }
    public void mergeLocalCart(Collection<OrderedProduct> orderedProducts, User user) {

    }

    public void delete(String itemId, User user) {

    }

    public void checkout(User user) {

    }
}
