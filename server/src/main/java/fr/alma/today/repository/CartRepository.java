package fr.alma.today.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.alma.today.models.Cart;
import fr.alma.today.models.User;

public interface CartRepository extends MongoRepository<Cart, Integer> {
}
