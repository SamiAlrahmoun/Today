package fr.alma.today.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.alma.today.models.Order;


public interface OrderRepository extends MongoRepository<Order, Integer>{

}
