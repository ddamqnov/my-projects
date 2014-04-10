package com.springapp.controller;

import com.springapp.model.Ad;
import com.springapp.model.User;
import com.springapp.service.AdService;
import com.springapp.service.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class HelloController {

    @Autowired
    AdService adService;

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String hi(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }


}