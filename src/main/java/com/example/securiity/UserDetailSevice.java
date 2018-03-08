/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.securiity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import com.example.dao.CurrentUserRepository;

import com.example.entities.CurrentUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
/**
 *
 * @author Kazzy Rantsimele <kazzytheman345@gmail.com>
 */
@Component
public class UserDetailSevice implements UserDetailsService{
     @Autowired CurrentUserRepository repo;
     
    @Override
    public User loadUserByUsername(String username){
        CurrentUser user = repo.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
          if(user.getRoles().contains("ROLE_ADMIN")){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
              authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
           return new User(user.getUsername(), user.getPassword(),true, true, 
                 true, true, authorities);
         }else if(!user.getRoles().contains("ROLE_ADMIN")){
             authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
         }
         return new User(user.getUsername(), user.getPassword(),true, true, 
                 true, true, authorities);
    }
 
}


















