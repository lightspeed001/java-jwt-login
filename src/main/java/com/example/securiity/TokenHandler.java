/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.securiity;

import org.springframework.security.core.userdetails.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
import org.springframework.stereotype.Component;
/**
 *
 * @author Kazzy Rantsimele <kazzytheman345@gmail.com>
 */
@Component
public final class TokenHandler {
    @Autowired private UserDetailSevice userDetails;
    
  private static final String secret = "iycagb!coac!hcphckcuvgc!ubh#nhx";
  private Log logger = LogFactory.getLog(TokenHandler.class);
	

	public TokenHandler() {}

  public User parseUserFromToken(String token) {
        String username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        return userDetails.loadUserByUsername(username);  
    }
    
    public String createTokenForUser(User user) {
        logger.info(user);
       return Jwts.builder().setSubject(user.getUsername()).signWith(SignatureAlgorithm.HS512, secret).compact();
    }
}





