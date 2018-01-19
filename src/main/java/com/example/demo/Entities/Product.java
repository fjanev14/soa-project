package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String prodName;
    private String modelNo;
    private String size;
    private String price;


    public Product(String prodName,String modelNo,String size,String price){
        this.prodName=prodName;
        this.modelNo=modelNo;
        this.size=size;
        this.price=price;

    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getProdName(){
        return prodName;
    }
    public void setProdName(String prodName){
        this.prodName=prodName;
    }
    public String getModelNo(){
        return modelNo;
    }
    public void setModelNo(String modelNo){
        this.modelNo=modelNo;
    }
    public String getSize(){
        return  size;
    }
    public void setSize(String size){
        this.size=size;
    }

    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price=price;
    }

}
