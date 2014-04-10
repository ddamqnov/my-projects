package com.springapp.repository;

import com.springapp.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Damqnov on 14-3-28.
 */
public interface AdRepository extends JpaRepository <Ad,Integer>{

    @Query("SELECT a FROM Ad a WHERE (a.user.email) = (:userName)")
    public List<Ad> getAllByUserName(@Param("userName") String userName);

    @Query("SElECT a.title,a.content,a.user.email FROM Ad a")
    public List<Ad> getALLAds();

    @Query("SELECT count(*) FROM Ad a WHERE (a.user.email) = (:userName)")
    public int getNumberOfAds(@Param("userName") String userName);

    @Query("SELECT a.title,a.content FROM Ad a WHERE (a.category.categoryName) = (:categoryName)")
    public List<Ad> getAllAdsByCategory(@Param("categoryName") String categoryName);

//    @Query("SELECT count(*) FROM Ad a WHERE (a.category.categoryName) = (:categoryName)")
//    public int getNumberOfAdsByCategory(@Param("categoryName") String categoryName);
}
