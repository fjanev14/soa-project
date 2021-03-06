package com.example.demo.Entities;

import javax.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastname;
    private String username;
    private String password;
    private String email;

    public User(String name,String lastname,String username,String password,String email){
        this.name=name;
        this.lastname=lastname;
        this.username=username;
        this.password=password;
        this.email=email;
    }

    @Override
    public String toString(){
        return  String.format("Comment [ id=%id, name='%s', lastname='%s', username='%s', password='%s', email='%s'] " ,
                id,name,lastname,username,password,email);

    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastName(String lastname){
        this.lastname=lastname;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }


}
