package com.haku.springbootdemo.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class AppUser {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    private String username;
//    private String password;
//
//    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<AppRole> roleSet;
//
//    public AppUser(String username){
//        this.username = username;
//    }
//
//    public AppUser(String username, String password, Set<AppRole> roles){
//        this.username = username;
//        this.password = password;
//        this.roleSet = roles;
//    }
//}


@Entity
public class AppUser {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<AppRole> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }

    public AppUser(String name, String password){
        this.username = name;
        this.password = password;
    }

    public AppUser(String name, String password, Set<AppRole> roleSet){
        this.username = name;
        this.password = password;
        this.roles = roleSet;
    }

    public AppUser(){}
}