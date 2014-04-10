package com.springapp.service;

import com.springapp.model.User;
import com.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damqnov on 14-4-1.
 */

@Service
public class UserLoginImpl implements  UserLogin{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUser(email);
    }


}
