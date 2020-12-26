package fr.alma.today.service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import fr.alma.today.models.User;


public class UserService {


   public User getCustomerByUsername(String username,MongoDatabase database ) {
       MongoCollection<User> user = database.getCollection("User", User.class);
       return   user.find(Filters.eq("username", username)).first();
    }
    public User getCustomerById(String userId,MongoDatabase database ) {
        MongoCollection<User> user = database.getCollection("User", User.class);
        return   user.find(Filters.eq("user_id", userId)).first();
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
