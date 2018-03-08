/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
/**
 *
 * @author Kazzy Rantsimele <kazzytheman345@gmail.com>
 */
@Entity
public class CurrentUser {
    @Id
    @GeneratedValue
    protected Long id;
    @CreatedDate //JPA Auditing
    protected Long createdDate;
    @LastModifiedDate //JPA Auditing
    protected Long modifiedDate;
    @LastModifiedBy //JPA Auditing
    protected String modifiedBy;
    private String phoneNumber;    
    private String username;
    private String password;
    private String lastSearcher;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLog;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSearch;
    @ElementCollection
    private Collection<String> roles = new ArrayList<> ();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getCreatedDate(){
    return createdDate;
    }
    
    public void setCreatedDate(Long createdDate){
    this.createdDate = createdDate;
    }
    
    public Long getModifiedDate(){
    return modifiedDate;
    }
    
    public void setModifiedDate(Long modifiedDate){
    this.modifiedDate = modifiedDate;
    }
    
    public String getModifiedBy(){
    return modifiedBy;
    }
    
    public void getModifiedBy(String modifiedBy){
    this.modifiedBy = modifiedBy;  
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
         
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getLastSearcher(){
    return lastSearcher;
    }
    
    public void setLastSearcher(String lastSearcher){
    this.lastSearcher = lastSearcher;
    }
    
    public Collection<String> getRoles(){
        return roles;
    }
    
    public void setRoles(Collection<String>roles){
        roles = this.roles;
    }
    
    public Date getlastLog(){
    return lastLog;
    }
    
    public void setlastLog(Date lastLog){
    this.lastLog = lastLog;
    }
    
    public Date getLastSearch(){
       return this.lastSearch;
    }
        
    public void setLastSearch(Date lastSearch){
        this.lastSearch = lastSearch;
    }
}



















































