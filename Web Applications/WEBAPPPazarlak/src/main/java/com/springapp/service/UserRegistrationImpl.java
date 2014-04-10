package com.springapp.service;

import com.springapp.model.Role;
import com.springapp.model.User;
import com.springapp.repository.RoleRepository;
import com.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Damqnov on 14-3-26.
 */
@Service
public class UserRegistrationImpl implements  UserRegistration{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public Role getRoleById(int id) {
        return roleRepository.getOne(id);
    }

    @Override
    public boolean isExist(String userName) {
        int temp = userRepository.getNumberOfUsers(userName);
        System.out.println(temp);
        if(temp == 1){
            return true;
        }else{
            return false;
        }
    }
}
