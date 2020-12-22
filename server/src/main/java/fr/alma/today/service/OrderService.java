package fr.alma.today.service;


import fr.alma.today.models.*;
import fr.alma.today.models.Order;
import fr.alma.today.repository.CartRepository;
import fr.alma.today.repository.OrderRepository;
import fr.alma.today.repository.ProductRepository;
import fr.alma.today.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    public Order buy (Integer id, Integer cardId, String addess){
        User client = userRepository.findUserByIdById(id);
        Cart cart = cartRepository.findCartByCartId(cardId);
        Order order = new Order(client.getUsername(), client.getEmail(), addess, cart.getProducts(),cart.getTotal(),cart.getSize());
        return orderRepository.save(order);
    }

}
