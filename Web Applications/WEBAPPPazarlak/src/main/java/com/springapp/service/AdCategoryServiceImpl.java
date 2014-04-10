package com.springapp.service;

import com.springapp.model.Category;
import com.springapp.repository.AdCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Damqnov on 14-4-5.
 */

@Service
@Transactional
public class AdCategoryServiceImpl implements AdCategoryService {

    @Autowired
    AdCategoryRepository adCategoryRepository;

    @Override
    public List<String> getAllCategoriesNames() {
        return adCategoryRepository.getAllCategoriesNames();
    }

    @Override
    public List<Category> getAllCategories() {
        return adCategoryRepository.findAll();
    }

    @Override
    public Category getCategoryByName(String name) {
        return adCategoryRepository.getCategoryByName(name);
    }

    @Override
    public Category getCategoryById(int id) {
        return adCategoryRepository.getOne(id);
    }
}
