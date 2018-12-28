package com.haku.springbootdemo.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class AppRole {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    private String rolename;
//
//    @ManyToMany(mappedBy = "roleSet")
//    private Set<AppUser> userSet;
//
//    public AppRole(String rolename){
//        this.rolename = rolename;
//    }
//}

@Entity
public class AppRole {
    private Long id;
    private String name;
    private Set<AppUser> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<AppUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }

    public AppRole(String name){

        this.name = name;
    }

    public AppRole(){}
}