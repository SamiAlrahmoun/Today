package fr.alma.today.repository;

import fr.alma.today.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {

    public User findByUsername(String username);
    public User findById(int id);


}

