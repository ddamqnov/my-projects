package com.springapp.service;

import com.springapp.model.User;

/**
 * Created by Damqnov on 14-4-1.
 */
public interface UserLogin {

    public User getUser(int id);
    public User getUserByEmail(String email);

}
