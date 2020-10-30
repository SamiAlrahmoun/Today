package fr.alma.today.repository;

import fr.alma.today.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

     User findByUsername(String username);
     User findById(int id);


}

