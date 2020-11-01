package fr.alma.today.repository;

import fr.alma.today.models.Account;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.alma.today.models.Cart;
import fr.alma.today.models.User;


public interface AccountRepository extends MongoRepository<Account, Integer>{
    Account findById(String id);
    void deleteById(String id);
}
