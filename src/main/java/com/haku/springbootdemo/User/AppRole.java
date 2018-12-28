package com.haku.springbootdemo.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String rolename;

//    @ManyToMany(mappedBy = "roleSet")
//    private Set<AppUser> userSet;
//
//    public AppRole(String rolename){
//        this.rolename = rolename;
//    }
}
