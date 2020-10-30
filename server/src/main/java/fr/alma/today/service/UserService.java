package fr.alma.today.service;



import fr.alma.today.models.User;

import java.util.List;

public class UserService {


    User getCustomerByName(String name);

    int getCountCustomer();

    User save(User user);
    //User update(User user);
    //User delete(User user);

}
