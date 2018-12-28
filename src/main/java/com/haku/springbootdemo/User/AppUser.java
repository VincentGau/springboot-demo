package com.haku.springbootdemo.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;

//    @ManyToMany(cascade = CascadeType.MERGE)
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
}
