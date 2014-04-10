package com.springapp.repository;

import com.springapp.model.Ad;
import com.springapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Damqnov on 14-3-26.
 */


public interface UserRepository  extends JpaRepository<User,Integer> {

    @Query ("SELECT u FROM User u WHERE (u.email) = (:userName)")
    public User getUser(@Param("userName") String userName);

    @Query ("SELECT count(*) FROM User u WHERE (u.email) = (:userName)")
    public int getNumberOfUsers(@Param("userName") String userName);

}
