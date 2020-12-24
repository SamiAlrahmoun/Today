package fr.alma.today.service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fr.alma.today.models.Cart;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Predicate;

import static com.mongodb.client.model.Filters.eq;

public class CartService {

    private ProductService productService = new ProductService();

    public Cart saveCart(Cart cart, MongoDatabase database){
        MongoCollection<Cart> carts = database.getCollection("Cart", Cart.class);
        carts.insertOne(cart);
       // database.getCollection("Cart").find(Filters.eq("_id", cart)).first().toJson()
        System.out.println("Cart inserted.");

        // find this grade.
       // Grade grade = grades.find(eq("student_id", 10003d)).first();


        return getCart(cart.getCartId(),database);
    }
    public Cart getCart(String cardId, MongoDatabase database){
        return database.getCollection("Cart", Cart.class).find(Filters.eq("user_id", cardId)).first();
    }

    public Cart addToCart(String cartId, String productID, MongoDatabase database){
        Product product = productService.getProduct(productID,database);
        Cart cart  = getCart(cartId, database);
        cart.getProducts().removeIf((Predicate<? super Product>) product);
        cart.setSize(cart.getProducts().size());
        cart.setTotal(cart.cartPrice(cart.getProducts()));
        return saveCart(cart,database);
    }

    public  Cart removeToCart(String cartId, String productID, MongoDatabase database) {
        Product product = productService.getProduct(productID,database);
        Cart cart = getCart(cartId, database);
        cart.getProducts().add(product);

        cart.setSize(cart.getProducts().size());
        cart.setTotal(cart.cartPrice(cart.getProducts()));
        return saveCart(cart,database);
    }

    public void checkout(User user) {

    }
}
