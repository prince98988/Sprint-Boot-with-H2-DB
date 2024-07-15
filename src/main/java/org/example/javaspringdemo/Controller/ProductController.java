package org.example.javaspringdemo.Controller;

import org.example.javaspringdemo.Interface.ProductServiceInterface;
import org.example.javaspringdemo.Models.Product;
import org.example.javaspringdemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductServiceInterface productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Product> getProduct(@PathVariable int prodId){
        Product product = productService.getProduct(prodId);
        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId){
        productService.deleteProduct(prodId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @GetMapping("/searchProducts")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        System.out.println(keyword);
        return new ResponseEntity<>(productService.searchProducts(keyword), HttpStatus.OK);
    }

}
