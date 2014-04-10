package com.springapp.service;

import com.springapp.model.Category;

import java.util.List;

/**
 * Created by Damqnov on 14-4-5.
 */
public interface AdCategoryService {

    public List<String> getAllCategoriesNames();
    public List<Category> getAllCategories();
    public Category getCategoryByName(String name);
    public Category getCategoryById(int id);

}
