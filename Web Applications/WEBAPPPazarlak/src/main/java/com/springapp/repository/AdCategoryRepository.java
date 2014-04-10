package com.springapp.repository;

import com.springapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Damqnov on 14-4-5.
 */
public interface AdCategoryRepository extends JpaRepository<Category,Integer>{

    @Query("SELECT c FROM Category c WHERE (c.categoryName) = (:name)")
    public Category getCategoryByName(@Param("name")String name);

    @Query("SELECT c.categoryName FROM Category c ")
    public List<String> getAllCategoriesNames();
}
