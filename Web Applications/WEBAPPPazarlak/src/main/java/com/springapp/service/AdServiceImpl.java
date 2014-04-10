package com.springapp.service;

import com.springapp.model.Ad;
import com.springapp.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Damqnov on 14-3-28.
 */
@Service
@Transactional
public class AdServiceImpl implements  AdService{


    @Autowired
    private AdRepository adRepository;


    @Override
    public List<Ad> getUserAds(String userName) {
        return adRepository.getAllByUserName(userName);
    }

    @Override
    public void save(Ad ad) {
        adRepository.save(ad);
    }

    @Override
    public Ad get(int id) {
        return adRepository.getOne(id);
    }

    @Override
    public List<Ad> getAllAdsByCategory(String categoryName) {
        return adRepository.getAllAdsByCategory(categoryName);
    }

    @Override
    public List<Ad> getAllAds() {
        return  adRepository.getALLAds();
    }

    @Override
    public int getNumberOfAds(String userName) {
        return adRepository.getNumberOfAds(userName);
    }


}
