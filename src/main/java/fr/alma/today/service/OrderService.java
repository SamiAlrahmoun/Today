package fr.alma.today.service;



import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fr.alma.today.models.*;
import fr.alma.today.models.Order;

public class OrderService {
 private UserService userService = new UserService();
    private CartService cartService = new CartService() ;
    public Order buy (String cardId, String addess, MongoDatabase database){
        User client = this.userService.getCustomerById(cardId,database);
        Cart cart = this.cartService.getCart(cardId,database);
        Order order = new Order(client.getUsername(), client.getEmail(), addess, cart.getProducts(),cart.getTotal(),cart.getSize());
        MongoCollection<Order> orders = database.getCollection("Order", Order.class);
        orders.insertOne(order);
        // database.getCollection("Cart").find(Filters.eq("_id", cart)).first().toJson()
        System.out.println("Orders inserted.");
        return getOrder(cardId,database);
    }
    public Order getOrder(String id, MongoDatabase database){
        MongoCollection<Order> order = database.getCollection("Order", Order.class);
        return   order.find(Filters.eq("email", id)).first();

    }

}
