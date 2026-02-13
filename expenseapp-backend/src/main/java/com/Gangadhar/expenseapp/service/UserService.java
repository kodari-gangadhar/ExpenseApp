package com.Gangadhar.expenseapp.service;

import com.Gangadhar.expenseapp.entity.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();
    User getUserById(Long id);


}
