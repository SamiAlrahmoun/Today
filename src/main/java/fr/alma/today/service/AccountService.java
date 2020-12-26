package fr.alma.today.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.alma.today.models.Account;
import fr.alma.today.models.Cart;

public class AccountService {

    public void saveAccount(Account account, MongoDatabase database){
        MongoCollection<Account> accounts = database.getCollection("Account", Account.class);
        accounts.insertOne(account);
        // database.getCollection("Cart").find(Filters.eq("_id", cart)).first().toJson()
        System.out.println("Account inserted.");

        // find this grade.
        // Grade grade = grades.find(eq("student_id", 10003d)).first();
        // return cartRepository.save(cart);
    }

}
