package com.example.demo.Service;


import com.example.demo.Entities.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableAutoConfiguration
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     *
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUsername(String username){
        return (User) userRepository.findByUsername(username);
    }

    public User save(String name,String lastname,String username,String password,String email){
        User user=findByUsername(username);

        if(user==null){
            user=new User(name,lastname,username,password,email);
        }else{
            user.setName(name);
            user.setLastName(lastname);
            user.setPassword(password);
        }
        return userRepository.save(user);
    }

    public User loging(String username,String password){
        List<User> userByUsername=userRepository.findByUsername(username);

        if(userByUsername!=null) {
            User user = userByUsername.get(0);
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return  null;
    }

    public User updateUser(Long id,String name,String lastname,String email){
        User oldUser=userRepository.findOne(id);
        oldUser.setId(id);
        oldUser.setName(name);
        oldUser.setLastName(lastname);
        oldUser.setEmail(email);

        return  userRepository.save(oldUser);
    }

    public User findById(Long id){
        return userRepository.findOne(id);
    }

    public Iterable<User> findAllUsers(){
       return  userRepository.findAll();
    }


}
