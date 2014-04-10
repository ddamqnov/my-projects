package com.springapp.service;

import com.springapp.model.Role;
import com.springapp.model.User;

/**
 * Created by Damqnov on 14-3-26.
 */

public interface UserRegistration {

    public void save (User user );
    public Role getRoleById(int id);
    public boolean isExist(String userName);
}
