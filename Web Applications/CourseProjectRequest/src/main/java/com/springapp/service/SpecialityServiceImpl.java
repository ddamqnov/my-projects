package com.springapp.service;

import com.springapp.model.Speciality;
import com.springapp.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Damqnov on 14-4-28.
 */

@Service
@Transactional
public class SpecialityServiceImpl implements  SpecialityService{

    @Autowired
    private SpecialityRepository specialityRepository;


    @Override
    public List<String> getAllSpecialityNames() {
        return specialityRepository.getAllSpecialityNames();
    }
}
