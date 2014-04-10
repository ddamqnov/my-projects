package com.springapp.controller;

import com.springapp.model.Category;
import com.springapp.service.AdCategoryService;
import com.springapp.service.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Damqnov on 14-4-5.
 */

@Controller
public class AdCategoryController {

    @Autowired
    AdCategoryService adCategoryService;


    @RequestMapping(value = "/ad/categories",method = RequestMethod.GET)
    public @ResponseBody boolean getNumberOfAdsInCategory(){
        return true;
    }

    @RequestMapping(value = "/get-categories",method = RequestMethod.GET)
    public @ResponseBody List<String> getAllCategories(){
        return adCategoryService.getAllCategoriesNames();
    }
}
