/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest;

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
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
/**
 *
 * @author Kazzy Rantsimele <kazzytheman345@gmail.com>
 */
@RestController

public class UserBean {

 private Log logger = LogFactory.getLog(UserBean.class);        
 @Autowired private UserServ deets;
   
         @RequestMapping(value = { "/api/user/login" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTest(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException, IOException, ServletException {
         String user = request.getParameter("username");
         String pwd = request.getParameter("password");
          logger.info(user+""+pwd);
         if(user!=null){         
             Map mm = new HashMap<>();
             mm.put("session_token","this is the session token");         
          /** User uu = deets.loadUserByUsername(user);
           if(encoder.matches(pwd,uu.getPassword())){
            String token = tokenHandler.createTokenForUser(uu);**/ 
               /**HttpHeaders responseHeaders = new HttpHeaders();
               responseHeaders.set(AUTH_HEADER_NAME, token);   **/ 
             /**  return new ResponseEntity("Good",responseHeaders,HttpStatus.ACCEPTED);
           } else {
             return new ResponseEntity("Ehhh wrong",HttpStatus.BAD_REQUEST);
           }***/
             return new ResponseEntity(mm,HttpStatus.ACCEPTED);
           
         } else {
              return new ResponseEntity("Ehhh wrong",HttpStatus.BAD_REQUEST);
         }    
         }
         
         @RequestMapping(value = { "/hello" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JHello(HttpServletRequest request, HttpServletResponse response){
         return null;
         }
         
         @RequestMapping(value = { "/api/user/add" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JSignup(HttpServletRequest request, HttpServletResponse response){
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String number = request.getParameter("phone");
         logger.info(username+""+password+""+number);
         
         return new ResponseEntity("Yaas",HttpStatus.ACCEPTED);
         }
         
         @RequestMapping(value = { "/reg/testE" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTestE(HttpServletRequest request, HttpServletResponse response){
         return null;
         }
         
         @RequestMapping(value = { "/api/user/logout" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTestOut(HttpServletRequest request, HttpServletResponse response){
         return null;
         }
         
         @RequestMapping(value = { "/api/users" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTestUsers(HttpServletRequest request, HttpServletResponse response){
         return null;
         }
            
         @RequestMapping(value = { "/reg/testU" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
         public ResponseEntity JTestU(HttpServletRequest request, HttpServletResponse response){
         return null;
         }
            
}



































































