package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryId;

    private String deliveryName;
    private String prodName;
    private String contactNumber;
    private String address;
    private Long amount;
    private String userName;
    private Long userID;

    public Delivery(String deliveryName,String prodName,String contactNumber,String address,Long amount,String userName,Long userID){
        this.deliveryName=deliveryName;
        this.prodName=prodName;
        this.contactNumber=contactNumber;
        this.address=address;
        this.amount=amount;
        this.userName=userName;
        this.userID=userID;
    }

    public Long getDeliveryId(){
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId){
        this.deliveryId=deliveryId;
    }

    public String getDeliveryName(){
        return deliveryName;
    }
    public void setDeliveryName(String deliveryName){
        this.deliveryName=deliveryName;
    }
    public String getProdName(){
        return prodName;
    }

    public void setProdName(String prodName){
        this.prodName=prodName;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber=contactNumber;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount){
        this.amount=amount;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public Long getUserID(){
        return userID;
    }

    public void setUserID(Long userID){
        this.userID=userID;
    }
}
