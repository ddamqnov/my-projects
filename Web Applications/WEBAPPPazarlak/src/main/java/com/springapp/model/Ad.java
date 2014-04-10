package com.springapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Damqnov on 14-3-28.
 */

@Entity
public class Ad {

    @GeneratedValue
    @Id
    private Integer id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_ads",
            joinColumns = {@JoinColumn(name="ad_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
    )


    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "ad_category",
            joinColumns = {@JoinColumn(name="ad_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="category_id", referencedColumnName="id")}
    )

    Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
