package com.haku.springbootdemo.Auth;

import com.haku.springbootdemo.User.AppRole;
import com.haku.springbootdemo.User.AppUser;
import com.haku.springbootdemo.User.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
    private AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username){
//        AppUser user = appUserRepository.findByUsername(username);
//        if(user != null){
//            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            return new User(user.getUsername(), user.getPassword(),authorities);
//        }
//        throw new UsernameNotFoundException("User " + username + " not found.");
//    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        AppUser user = appUserRepository.findByUsername(username);

        if(user != null){
            Set<GrantedAuthority> authorities = new HashSet<>();
            for(AppRole role:user.getRoles()){
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }

            return new User(user.getUsername(), user.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("User " + username + " not found.");
    }
}
