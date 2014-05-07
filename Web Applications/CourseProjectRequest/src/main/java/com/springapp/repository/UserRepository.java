package com.springapp.repository;

import com.springapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Damqnov on 14-4-17.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE (u.name) = (:userName)")
    public User getUser(@Param("userName") String userName);
}
