package fr.alma.today.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.alma.today.models.Cart;
import fr.alma.today.models.User;


import java.util.List;

public interface CartRepository extends MongoRepository<Cart, Integer> {
    Cart findByUsername(String id);
    Cart findById(String id);
    List<Cart> findAll(String id);


}
