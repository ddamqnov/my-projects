package com.springapp.controller;

import com.springapp.model.Ad;
import com.springapp.model.Category;
import com.springapp.model.RequestAd;
import com.springapp.model.User;
import com.springapp.service.AdCategoryService;
import com.springapp.service.AdService;
import com.springapp.service.UserLogin;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damqnov on 14-4-5.
 */

@Controller
public class AdController {

    @Autowired
    AdService adService;

    @Autowired
    AdCategoryService adCategoryService;

    @Autowired
    UserLogin userLogin;

    @RequestMapping(value = "/ad/save",method = RequestMethod.GET)
    public String saveAdGet(){
        return "index";
    }


    @RequestMapping(value = "/ad/save",method = RequestMethod.POST  , headers = "Content-Type=application/json")
    public @ResponseBody String saveAd(@RequestBody RequestAd requestAd){


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            User userLogged =  userLogin.getUserByEmail(auth.getName());

            Category category = adCategoryService.getCategoryByName(requestAd.getCategory());
            System.out.println(category.getCategoryName());
            System.out.println(category.getId());

            Ad ad = new Ad();
            ad.setTitle(requestAd.getTitle());
            ad.setContent(requestAd.getTitle());
            ad.setCategory(category);
            ad.setUser(userLogged);

            adService.save(ad);

            return "Success!";

        }else{
            return  "Error!";
        }
    }

    @RequestMapping(value = "/ad/all" , method = RequestMethod.GET)
    public @ResponseBody
    List<Ad> getAllAds() {
        return adService.getAllAds();
    }

    @RequestMapping(value = "/ad/by+category" , method = RequestMethod.GET)
    public @ResponseBody
    List<Ad> getAllAdsByCategory() {
        return adService.getAllAdsByCategory("Автомобили");
    }

    @RequestMapping(value = "/ad/by+category",method = RequestMethod.POST  , headers = "Content-Type=application/json")
    public @ResponseBody List<Ad> getAllAdsByCategory(@RequestBody Category category){
        System.out.println(category.getCategoryName());
        if(category.getCategoryName().equals("Всички обяви")){
            return adService.getAllAds();
        }
        return adService.getAllAdsByCategory(category.getCategoryName());
    }
}
