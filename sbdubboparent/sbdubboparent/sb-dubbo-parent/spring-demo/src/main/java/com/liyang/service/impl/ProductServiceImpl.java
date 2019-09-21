package com.liyang.service.impl;

import com.liyang.pojo.Product;
import com.liyang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private Product product ;

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
    @Override
    public void getPro() {
        System.out.println(product.getName());
        System.out.println(product.getPid());
        System.out.println(product.getAddress());
    }
}
