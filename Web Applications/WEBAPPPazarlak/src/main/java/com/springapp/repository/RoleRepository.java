package com.springapp.repository;

import com.springapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Damqnov on 14-3-26.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
