/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.dao.CurrentUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.entities.CurrentUser;
import com.example.securiity.UserDetailSevice;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Kazzy Rantsimele <kazzytheman345@gmail.com>
 */
@Service
public class UserServ {
    @Autowired CurrentUserRepository repo;
    @Autowired UserDetailSevice serv;
    
    public List<CurrentUser> getAllUsers(){
    return repo.getAllUsers();
    }
    
    public List<String> getUsernames(){
    return repo.getUsernames();
    }
    
    public List<String> getEmails(){
    return repo.getEmails();   
    }
    
    public void setLastLogged(String lastLog){
    repo.setLastLogged(lastLog);
    }
    
    public User loadUserByUsername(String username){
    return serv.loadUserByUsername(username); 
    }
}






























