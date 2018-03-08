/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
/**
 *
 * @author Katlego Rantsimele <katlego@pheatur.com>
 */
@Service
public class DemoNode {
    @Autowired Environment env;
    protected ObjectMapper mapper = new ObjectMapper();
    protected ObjectNode node = mapper.createObjectNode();
    protected ArrayNode array = mapper.createArrayNode();
    
    public ObjectNode getNode(){
        return new ObjectMapper().createObjectNode();
    }
    
    public ArrayNode getArray(){
         return new ObjectMapper().createArrayNode();
    }
    
    public String getAppSecret(){
        return env.getProperty("app.secret");
    }

   public String getSecret(){
       return env.getProperty("web.secret");
   }
}




