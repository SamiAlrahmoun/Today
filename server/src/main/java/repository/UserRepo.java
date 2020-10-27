package repository;

import document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User, Integer> {

    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public List<User> findById(int id);
}

