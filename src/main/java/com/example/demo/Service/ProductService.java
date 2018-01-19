package com.example.demo.Service;


import com.example.demo.Entities.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product findByProductName(String prodName){
        return productRepository.getByProdName(prodName);
    }

    public Product updateProduct(Long id,String prodName,String modelNo,String size,String price) {
        Product oldProduct = productRepository.findOne(id);
        oldProduct.setProdName(prodName);
        oldProduct.setModelNo(modelNo);
        oldProduct.setSize(size);
        oldProduct.setPrice(price);
        return productRepository.save(oldProduct);
    }

    public Product createProduct(String prodName,String modelNo,String size,String price){
        Product product=productRepository.getByProdName(prodName);
        if(product==null){
            product=new Product(prodName,modelNo,size,price);
        }
        return productRepository.save(product);
    }
    public void deleteProduct(Long id){
        Product delProduct=productRepository.findOne(id);
        productRepository.delete(delProduct);
    }

    public Product findById(Long id){
        return productRepository.findOne(id);
    }
}
