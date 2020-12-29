package fr.alma.today.service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import fr.alma.today.models.Cart;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;
import org.bson.conversions.Bson;


import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;


public class CartService {

    private ProductService productService = new ProductService();

    public Cart saveCart(Cart cart, MongoDatabase database){
        MongoCollection<Cart> carts = database.getCollection("Cart", Cart.class);
        carts.insertOne(cart);
        System.out.println("Cart inserted.");


        return getCart(cart.getCartId(),database);
    }

    public Cart getCart(String cartId, MongoDatabase database){
        return database.getCollection("Cart", Cart.class).find(Filters.eq("cart_id", cartId)).first();
    }
//adding the producrt to the cart
    public Cart addToCart(String cartId, String productID, MongoDatabase database){
        Product product = productService.getProduct(productID,database);
        Cart cart  = getCart(cartId, database);

        product.setQuantity(1);
        cart.addToCart(product);
        cart.setSize(cart.getProducts().size());
        cart.setTotal(cart.cartPrice(cart.getProducts()));
        Bson update1 = inc("size", 1); // increment quantity by 1.
        Bson update2 = set("total", cart.getTotal()); // get the total number of product in cart.
        Bson update3 = push("products", product); // push the product in list array in the database.
        Bson updates = combine(update1, update2, update3);
        FindOneAndUpdateOptions optionAfter = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);//updating the cart and returning the new cart
        Cart newCart= database.getCollection("Cart", Cart.class).findOneAndUpdate(eq("cart_id",cart.getCartId()),updates,optionAfter);
        return newCart;
    }

    public  Cart removeToCart(String cartId, String productID, MongoDatabase database) {
        Product product = productService.getProduct(productID,database);
        Cart cart = getCart(cartId, database);
        cart.removeToCArt(product);
        cart.setSize(cart.getProducts().size());
        cart.setTotal(cart.cartPrice(cart.getProducts()));
        Bson update1 = set("size", cart.getSize()); // increment x by 10. As x doesn't exist yet, x=10.
        Bson update2 = set("total", cart.getTotal()); // rename variable "class_id" in "new_class_id".
        Bson update3 = set("products", cart.getProducts()); // creating an array with a comment.
        Bson updates = combine(update1, update2, update3);
        FindOneAndUpdateOptions optionAfter = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);
        Cart newCart= database.getCollection("Cart", Cart.class).findOneAndUpdate(eq("cart_id",cart.getCartId()),updates,optionAfter);
        return newCart;
    }

}
