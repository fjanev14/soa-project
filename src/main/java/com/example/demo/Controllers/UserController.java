package com.example.demo.Controllers;


import com.example.demo.Entities.User;
import com.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final String template="Hello %s!";
    private  final AtomicLong counter=new AtomicLong();

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name",defaultValue ="World")String name){
        return counter.incrementAndGet()+"";
    }

    @RequestMapping(value="/createNewUser",method = RequestMethod.GET)
    public User createNew(@RequestParam String name,@RequestParam String lastName,@RequestParam String username,@RequestParam String password,@RequestParam String email) throws Exception {
        User user=userService.findByUsername(username);
        if(user!=null)
            throw new Exception("Username taken!!");
        return userService.save(name,lastName,username,password,email);
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public User updateUser(@RequestParam String name,@RequestParam String lastname,@RequestParam String username,@RequestParam String password,@RequestParam String email) throws Exception {
        User user=userService.findByUsername(username);
        if(user!=null)
            throw new Exception("No user was found");
        return userService.save(name,lastname,username,passwordEncoder.encode(password),email);
    }

    @RequestMapping("/getUserById")
    public User getById(@RequestParam(value = "id",defaultValue = "-1")Long id){
        User userFound=userService.findById(id);
        return  userFound;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginUser(@RequestParam(required = false)String username,@RequestParam(required=false)String password){
        if(username.trim().isEmpty()&&!password.trim().isEmpty()){
            User user=userService.loging(username,password);
            if(user!=null){
                return user.toString();
            }else{
                return "Wrong username or password";
            }
        }
        return "Try again!!!";
    }

}
