package com.example.demo.Repository;

import com.example.demo.Entities.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery,Long> {

    List<Delivery> getByDeliveryName(String deliveryName);
}
