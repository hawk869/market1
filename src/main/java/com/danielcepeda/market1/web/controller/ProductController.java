package com.danielcepeda.market1.web.controller;

import com.danielcepeda.market1.domain.Product;
import com.danielcepeda.market1.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
//    @GetMapping("/{id}")
//    public Optional<Product> getProduct(@PathVariable("id") int productId) {
//        return productService.getProduct(productId);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) {
    return productService.getProduct(productId)
            .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
    @GetMapping("/category/{categoryId}")
//    public Optional<List<Product>> getByCategory(@PathVariable int categoryId) {
//        return productService.getByCategory(categoryId);
//    }
    public ResponseEntity<List<Product>> getByCategory(int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if (productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
