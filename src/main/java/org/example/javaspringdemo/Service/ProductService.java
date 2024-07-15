package org.example.javaspringdemo.Service;

import org.example.javaspringdemo.Interface.ProductServiceInterface;
import org.example.javaspringdemo.Models.Product;
import org.example.javaspringdemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements  ProductServiceInterface{
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(int prodId){
        return productRepository.findById(prodId).orElse(null);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(int prodId){
         productRepository.deleteById(prodId);
    }

    public List<Product> searchProducts(String keyword){
        return productRepository.searchProducts(keyword);
    }
}
