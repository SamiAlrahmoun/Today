package fr.alma.today.service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fr.alma.today.models.Account;
import fr.alma.today.repository.CartRepository;
import fr.alma.today.repository.UserRepository;

import fr.alma.today.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


public class UserService {
    @Autowired
    private UserRepository userRepository;

   public User getCustomerByUsername(String username,MongoDatabase database ) {
       MongoCollection<User> user = database.getCollection("User", User.class);
       return   user.find(Filters.eq("username", username)).first();
    }

    public User saveUser(User user, MongoDatabase database){
        MongoCollection<User> users = database.getCollection("User", User.class);
        users.insertOne(user);
        // database.getCollection("Cart").find(Filters.eq("_id", cart)).first().toJson()
        System.out.println("Account inserted.");

        // find this grade.
        // Grade grade = grades.find(eq("student_id", 10003d)).first();
         return   users.find(Filters.eq("username", user.getUsername())).first();
    }


}
