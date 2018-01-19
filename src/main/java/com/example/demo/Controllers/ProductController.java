package com.example.demo.Controllers;


import com.example.demo.Entities.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/getProductByName",method = RequestMethod.GET)
    public String findByProductName(@RequestParam String productName){
        Product product=productService.findByProductName(productName);
        if(product!=null){
             return  product.toString();
        }
        return "Product not found";
    }
    @RequestMapping(value = "/updateProduct",method = RequestMethod.GET)
    public Product updateProduct(@RequestParam Long id,@RequestParam String prodName,@RequestParam String modelNo,@RequestParam String size,@RequestParam String price){
        Product product=productService.findByProductName(prodName);
        return productService.updateProduct(id,prodName,modelNo,size,price);
    }
    @RequestMapping(value = "/getProdById",method = RequestMethod.GET)
    public Product findById(@RequestParam(value = "id",defaultValue = "-1")Long id){
        Product product=productService.findById(id);
        return product;
    }

    @RequestMapping(value="/createProduct",method = RequestMethod.PATCH)
    public Product createProduct(@RequestParam String prodName, @RequestParam String modelNo, @RequestParam String size, @RequestParam String price){
        return productService.createProduct(prodName,modelNo,size,price);
    }
}
