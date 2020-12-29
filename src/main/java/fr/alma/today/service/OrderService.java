package fr.alma.today.service;



import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fr.alma.today.models.*;
import fr.alma.today.models.Order;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;
public class OrderService {
 private UserService userService = new UserService();
    private CartService cartService = new CartService() ;
    private ProductService productService = new ProductService();
    public Order buy (String cardId, String addess, MongoDatabase database){
        User client = this.userService.getCustomerById(cardId,database);
        Cart cart = this.cartService.getCart(cardId,database);

        cart.getProducts().forEach(product -> {
            //We check if the producr quanntity is greater zero to buy
            //if no we remove from the cart before buying
           // System.out.println(product.getId());
            if (productService.getProduct(product.getId(),database).getQuantity()>0){

                database.getCollection("Product",Product.class).findOneAndUpdate(eq("product_id",product.getId()),inc("quantity", -1));
            }else {
                cartService.removeToCart(cardId, product.getId(), database);
            }

        });

        Cart newCart = this.cartService.getCart(cardId,database);
        Order order = new Order(client.getUsername(), client.getEmail(), addess, newCart.getProducts(),newCart.getTotal(),newCart.getSize());
        MongoCollection<Order> orders = database.getCollection("Order", Order.class);
        orders.insertOne(order);
        System.out.println("Orders inserted.");
        newCart.getProducts().forEach(product -> {
            Bson update1 = inc("quantity", -1); // decrement the quantity by one .
            Bson update2 = set("locked", false); // release the product after using it.
            Bson updates = combine(update1, update2);
            database.getCollection("Product",Product.class).findOneAndUpdate(eq("product_id",product.getId()),updates);
        });
        // database.getCollection("Cart").find(Filters.eq("_id", cart)).first().toJson()

        return getOrder(cardId,database);
    }
    public Order getOrder(String id, MongoDatabase database){
        MongoCollection<Order> order = database.getCollection("Order", Order.class);
        return   order.find(Filters.eq("email", id)).sort(new BasicDBObject("_id", -1)).first();

    }

}
