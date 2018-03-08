/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author Kazzy Rantsimele <kazzytheman345@gmail.com>
 */
@Controller
public class MainController {
     
    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/users")
    public String user() {
        return "/user";
    }
    
       @GetMapping("/signup")
    public String signUp() {
        return "/signup";
    }
    
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}












