package com.springapp.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Damqnov on 14-4-28.
 */

@Entity
public class Speciality {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    @Length(max = 15)
    @Column(unique = true)
    private String name ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
