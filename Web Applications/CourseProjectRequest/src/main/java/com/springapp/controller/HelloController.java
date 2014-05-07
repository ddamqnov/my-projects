package com.springapp.controller;

import com.springapp.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Damqnov on 14-4-17.
 */

@Controller
public class HelloController {

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String hi(ModelMap model) {
//        model.addAttribute("message", "Hello world!");

        return "index";
    }
}
