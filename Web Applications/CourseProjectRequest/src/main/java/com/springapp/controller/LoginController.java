package com.springapp.controller;

import com.springapp.model.*;
import com.springapp.model.Error;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Damqnov on 14-4-17.
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody
    com.springapp.model.Error isLogged(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return null;

        }else{
            return  new Error("Invalid user");
        }
    }

    @RequestMapping(value = "/login/user", method = RequestMethod.GET)
    public @ResponseBody  String logged(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return auth.getName();
        }else{
            return  null;
        }

    }
}

