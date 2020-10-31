package fr.alma.today.service;
import fr.alma.today.repository.UserRepository;

import fr.alma.today.models.User;

public class UserService {
 private UserRepository userRepo;

   public User getCustomerByUsername(String name) {
        return this.userRepo.findByUsername(name);
    }

    int getCountCustomer() {
        return 0;
    }



}
