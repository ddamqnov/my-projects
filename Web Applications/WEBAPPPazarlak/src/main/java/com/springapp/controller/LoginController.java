package com.springapp.controller;


import com.springapp.model.Error;
import com.springapp.model.VUser;
import com.springapp.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Damqnov on 14-4-1.
 */

@Controller
public class LoginController {

    @Autowired
    private AdService adService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody  Error isLogged(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return null;

        }else{
            return  new Error("Invalid user");
        }

    }

    @RequestMapping(value = "/login/user/information", method = RequestMethod.GET)
    public @ResponseBody  VUser logged(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            VUser vUser = new VUser();
            vUser.setMail(auth.getName());
            vUser.setNumberOfAds(adService.getNumberOfAds(auth.getName()));
            return vUser;

        }else{
            return  null;
        }

    }


}
