package repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String> {
    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
}

