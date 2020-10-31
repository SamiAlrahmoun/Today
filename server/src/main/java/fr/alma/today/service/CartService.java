package fr.alma.today.service;



import fr.alma.today.models.Cart;
import fr.alma.today.models.OrderedProduct;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;
import fr.alma.today.repository.CartRepository;

import javax.smartcardio.Card;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CartService {
private CartRepository cartRepository;
    private UserService userService = new UserService();
    private ProductService productService = new ProductService();

    public Cart getCart(String cardId){
        return cartRepository.findById(cardId);
    }
    public List<Cart> mCart(String cardId){
        return cartRepository.findAll(cardId);
    }
    public void mergeLocalCart(Collection<OrderedProduct> orderedProducts, User user) {

    }

    public Cart addToCart(String cartId, String productID){
        Product product = productService.getProductById(productID);
        Cart cart = getCart(cartId);
        cart.getProducts().add(product);
        cart.setSize(cart.getProducts().size());
        cart.setTotal(cart.cartPrice(cart.getProducts()));
        return cartRepository.save(cart);
    }

    public  Cart removeToCart(String cartId, String productID) {
        Product product = productService.getProductById(productID);
        Cart cart = getCart(cartId);
        cart.getProducts().add(product);
        cart.setSize(cart.getProducts().size());
        cart.setTotal(cart.cartPrice(cart.getProducts()));
        return cartRepository.save(cart);
    }

    public void checkout(User user) {

    }
}
