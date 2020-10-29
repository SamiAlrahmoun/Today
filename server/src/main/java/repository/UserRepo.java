package repository;

import document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {

    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public List<User> findById(int id);
}

