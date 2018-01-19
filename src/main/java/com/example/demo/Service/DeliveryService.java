package com.example.demo.Service;

import com.example.demo.Entities.Delivery;
import com.example.demo.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public List<Delivery> getByDeliveryName(String name){
        return deliveryRepository.getByDeliveryName(name);
    }

    public Delivery createDelivery(String deliveryName,String prodName,String contactNumber,String address,Long amount,String userName,Long userID){
        Delivery delivery= (Delivery) deliveryRepository.getByDeliveryName(deliveryName);

        if(delivery==null){
            delivery=new Delivery(deliveryName,prodName,contactNumber,address,amount,userName,userID);
        }
        return deliveryRepository.save(delivery);
    }
    public Delivery findById(Long id){
        return deliveryRepository.findOne(id);
    }

    public void deleteById(Long id){
        Delivery del=deliveryRepository.findOne(id);
        deliveryRepository.delete(del);
    }
}
