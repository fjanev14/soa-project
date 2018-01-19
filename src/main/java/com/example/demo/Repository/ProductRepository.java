package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    Product getByProdName(String prodName);
}
