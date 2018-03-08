/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest;

import com.example.services.DemoNode;
import com.example.entities.CurrentUser;
import com.example.securiity.TokenHandler;
import java.io.IOException;
import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.services.UserServ;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author Kazzy Rantsimele <kazzytheman345@gmail.com>
 */
@RestController
public class UserBean {

 private Log logger = LogFactory.getLog(UserBean.class);        
  @Autowired private UserServ deets;
  @Autowired private BCryptPasswordEncoder encoder;
  @Autowired private TokenHandler tokenHandler;
  @Autowired private DemoNode node;
   
         @RequestMapping(value = { "/api/user/login" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTest(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException, IOException, ServletException {
         String user = request.getParameter("username");
         String pwd = request.getParameter("password");
          logger.info(user+""+pwd);
         if(user!=null){         
             Map mm = new HashMap<>();
             mm.put("session_token","this is the session token");         
             User uu = deets.loadUserByUsername(user);
           if(encoder.matches(pwd,uu.getPassword())){
            String token = tokenHandler.createTokenForUser(uu);
            CurrentUser cu = deets.findByUsername(uu.getUsername());
            cu.setlastLog(new DateTime().toDate());
            
           mm.put("id",cu.getId());
           mm.put("session_token",token);
           
           return new ResponseEntity(mm,HttpStatus.ACCEPTED);
           } else {
             return new ResponseEntity("Ehhh wrong",HttpStatus.BAD_REQUEST);
           }
         } else {
              return new ResponseEntity("Ehhh wrong",HttpStatus.BAD_REQUEST);
         }    
         }
         
         @RequestMapping(value = { "/hello" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JHello(HttpServletRequest request, HttpServletResponse response){
         return new ResponseEntity("Hello World",HttpStatus.ACCEPTED);
         }
         
         @RequestMapping(value = { "/api/user/add" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JSignup(HttpServletRequest request, HttpServletResponse response){
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String number = request.getParameter("phone");
         //logger.info(username+""+password+""+number);
         
         CurrentUser uu = new CurrentUser();
         uu.setUsername(username);
         uu.setPassword(encoder.encode(password));
         uu.setPhoneNumber(number);
         uu.getRoles().add("ROLE_USER");
         uu.setLastSearch(new DateTime().toDate());
         
         Object o = deets.save(uu);
         return new ResponseEntity("Registration Successful",HttpStatus.ACCEPTED);
         }
         
         @RequestMapping(value = { "/reg/testE" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTestE(HttpServletRequest request, HttpServletResponse response){
         return new ResponseEntity(deets.getPhones(),HttpStatus.ACCEPTED);
         }
         
         @RequestMapping(value = { "/api/user/logout/{id}" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTestOut(HttpServletRequest request, HttpServletResponse response,@PathVariable Long id){
             User uu = tokenHandler.parseUserFromToken(request.getParameter("token"));
             CurrentUser u = deets.findByUsername(uu.getUsername());
             Object o = deets.save(u);
         return new ResponseEntity("Logout Successful",HttpStatus.ACCEPTED);
         }
         
         @RequestMapping(value = { "/api/users" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTestUsers(HttpServletRequest request, HttpServletResponse response){
             List<CurrentUser> users = deets.getAllUsers();
             List<ObjectNode> ll = new ArrayList<>(); 
             for(CurrentUser u: users){
             ObjectNode o = node.getNode();
             o.put("id",u.getId());
             o.put("phone",u.getPhoneNumber()); 
             ll.add(o);
             }
             Map mm = new HashMap<>();
             mm.put("users",ll);
         return new ResponseEntity(mm,HttpStatus.ACCEPTED);
         }
            
         @RequestMapping(value = { "/reg/testU" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTestU(HttpServletRequest request, HttpServletResponse response){
         return new ResponseEntity(deets.getUsernames(),HttpStatus.ACCEPTED);
         }
            
}



































































































































































































