/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.entities.CurrentUser;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
/**
 *
 * @author Kazzy Rantsimele <kazzytheman345@gmail.com>
 */
public interface CurrentUserRepository extends JpaRepository<CurrentUser, Long>{
    
   @Query("select u from CurrentUser u where u.username=:username")
   public CurrentUser findByUsername(@Param("username") String username);
   @Query("select u.username from CurrentUser u")
   public List<String> getUsernames();
   @Query("select u.phoneNumber from CurrentUser u")
   public List<String> getPhones();
   //public void setUser(String username, String phoneNumber, String password);
   @Query("select u.modifiedBy from CurrentUser u where u.modifiedBy=:lModified")
   public String getLastChange(@Param("lModified") String lModified);
   @Query("select u from CurrentUser u")
   public List<CurrentUser> getAllUsers();
   //public void save(CurrentUser u);
}






























































