package service;


import document.User;

import java.util.List;

public interface UserService {

    List<User> getCustomerList();

    List<User> getCustomerByName(String name);

    int getCountCustomer();

    User save(User user);
    //User update(User user);
    //User delete(User user);

}
