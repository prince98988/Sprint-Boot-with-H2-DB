package org.example.javaspringdemo.Interface;


import org.example.javaspringdemo.Models.Product;

import java.util.List;

public interface ProductServiceInterface {
    public List<Product> getProducts();
    public Product getProduct(int prodId);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(int prodId);
    public List<Product> searchProducts(String keyword);
}
