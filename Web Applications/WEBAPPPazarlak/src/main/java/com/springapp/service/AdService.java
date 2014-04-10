package com.springapp.service;

import com.springapp.model.Ad;

import java.util.List;

/**
 * Created by Damqnov on 14-3-28.
 */
public interface AdService {

    public List<Ad> getUserAds(String userName);
    public void save(Ad ad);
    public Ad get(int id);
    public List<Ad> getAllAdsByCategory(String categoryName);
    public List<Ad> getAllAds();
    public int getNumberOfAds(String userName);


}
