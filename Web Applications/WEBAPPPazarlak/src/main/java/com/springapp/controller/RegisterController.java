package com.springapp.controller;

import com.springapp.model.Ad;
import com.springapp.model.Role;
import com.springapp.model.User;
import com.springapp.repository.UserRepository;
import com.springapp.service.AdService;
import com.springapp.service.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by Damqnov on 14-3-26.
 */

@Controller
public class RegisterController {

    @Autowired
    private UserRegistration userRegistration;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdService adService;


    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public @ResponseBody boolean registerUser(@RequestBody User user){
        System.out.println(user.getEmail());
        if(userRegistration.isExist(user.getEmail()) == true){
            return false;
        }else{
           Role role = (Role) userRegistration.getRoleById(2);
            user.setRole(role);
            userRegistration.save(user);
            return  true;
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String nothing(){
        return "index";
    }


}
