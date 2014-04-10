package com.springapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Damqnov on 14-4-5.
 */

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    @Column(unique = true)
    private String categoryName;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ad_category",
            joinColumns = {@JoinColumn(name="category_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="ad_id", referencedColumnName="id")}
    )
    private List<Ad> ads;

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



}
