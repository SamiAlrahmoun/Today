package fr.alma.today.repository;

import fr.alma.today.models.Account;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.alma.today.models.Cart;
import fr.alma.today.models.User;


@Repository
public interface AccountRepository extends MongoRepository<Account, Integer>{
    Account findAccountBy(Integer id);
    void deleteById(Integer id);
}
