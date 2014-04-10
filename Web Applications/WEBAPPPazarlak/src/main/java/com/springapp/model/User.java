package com.springapp.model;

import org.hibernate.engine.spi.CascadeStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Damqnov on 14-3-26.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Length(max = 40)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
    private Role role;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_ads",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="ad_id", referencedColumnName="id")}
    )

    private List<Ad> userAds;

    public List<Ad> getUserAds() {
        return userAds;
    }

    public void setUserAds(List<Ad> userAds) {
        this.userAds = userAds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
