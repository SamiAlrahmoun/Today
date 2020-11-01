package fr.alma.today.service;


import fr.alma.today.models.*;
import fr.alma.today.models.Order;
import fr.alma.today.repository.CartRepository;
import fr.alma.today.repository.OrderRepository;
import fr.alma.today.repository.ProductRepository;
import fr.alma.today.repository.UserRepository;

public class OrderService {
    private UserRepository userRepository;
    private CartRepository cartRepository;
    private OrderRepository orderRepository;
    public Order buy (String id, String cardId, String addess){
        User client = userRepository.findById(id);
        Cart cart = cartRepository.findById(cardId);
        Order order = new Order(client.getUsername(), client.getEmail(), addess, cart.getProducts(),cart.getTotal(),cart.getSize());
        return orderRepository.save(order);
    }

}
