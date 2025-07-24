package com.franncodev.salescontrol.controller;

import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.model.Product;
import com.franncodev.salescontrol.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){
        ProductDTO createdProduct = productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<ProductDTO>> getProductList(){
        return ResponseEntity.ok(productService.getProductList());
    }

    @GetMapping("/{productId}")
    @ResponseBody
    public ResponseEntity<Optional<ProductDTO>> getProduct(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(product));
    }

}
