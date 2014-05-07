package com.springapp.repository;


import com.springapp.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Damqnov on 14-4-28.
 */
public interface SpecialityRepository extends JpaRepository<Speciality,Integer>{

    @Query("SELECT f.name FROM Speciality f")
    public List<String> getAllSpecialityNames();
}
