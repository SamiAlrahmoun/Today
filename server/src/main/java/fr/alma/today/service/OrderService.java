package fr.alma.today.service;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fr.alma.today.models.*;
import fr.alma.today.models.Order;
import fr.alma.today.repository.CartRepository;
import fr.alma.today.repository.OrderRepository;
import fr.alma.today.repository.ProductRepository;
import fr.alma.today.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
 private UserService userService;
    private CartService cartService;
    public Order buy (String id, String cardId, String addess, MongoDatabase database){
        User client = this.userService.getCustomerById(id,database);
        Cart cart = this.cartService.getCart(cardId,database);
        Order order = new Order(client.getUsername(), client.getEmail(), addess, cart.getProducts(),cart.getTotal(),cart.getSize());
        MongoCollection<Order> orders = database.getCollection("Order", Order.class);
        orders.insertOne(order);
        // database.getCollection("Cart").find(Filters.eq("_id", cart)).first().toJson()
        System.out.println("Orders inserted.");
        return getOrder(id,database);
    }
    public Order getOrder(String id, MongoDatabase database){
        MongoCollection<Order> order = database.getCollection("Order", Order.class);
        return   order.find(Filters.eq("user_id", id)).first();

    }

}
