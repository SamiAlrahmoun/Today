package fr.alma.today.service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fr.alma.today.models.Cart;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;
import fr.alma.today.repository.CartRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Predicate;

import static com.mongodb.client.model.Filters.eq;

public class CartService {
    @Autowired
    private CartRepository cartRepository ;
    private ProductService productService = new ProductService();

    public void saveCart(Cart cart, MongoDatabase database){
        MongoCollection<Cart> carts = database.getCollection("Cart", Cart.class);
        carts.insertOne(cart);
       // database.getCollection("Cart").find(Filters.eq("_id", cart)).first().toJson()
        System.out.println("Cart inserted.");

        // find this grade.
       // Grade grade = grades.find(eq("student_id", 10003d)).first();
        System.out.println(this.cartRepository);

       // return cartRepository.save(cart);
    }
    public Cart getCart(String cardId, MongoDatabase database){
        return database.getCollection("Cart", Cart.class).find(Filters.eq("user_id", cardId)).first()
    }
    public List<Cart> mCart(Integer cardId){
        return cartRepository.findAll();
    }

    public Cart addToCart(String cartId, Integer productID, MongoDatabase database){
        Product product = productService.getProductById(productID);
        Cart cart  = getCart(cartId, database);
        cart.getProducts().removeIf((Predicate<? super Product>) product);
        cart.setSize(cart.getProducts().size());
        cart.setTotal(cart.cartPrice(cart.getProducts()));
        return cartRepository.save(cart);
    }

    public  Cart removeToCart(Integer cartId, Integer productID) {
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
