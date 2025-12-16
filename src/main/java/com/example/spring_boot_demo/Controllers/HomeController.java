package com.example.spring_boot_demo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {
 @GetMapping
    public String message(){
        return "Welcome to home page";
    }
    @GetMapping("/dashboard")
    public String getDashboard(){
     return "Login Succesful";
    }
}
