package com.franncodev.salescontrol.controller;

import com.franncodev.salescontrol.model.Product;
import com.franncodev.salescontrol.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/products/create")
    public String createProduct(@RequestBody Product product){
        productService.createProduct(product);

        return "Product created successfully";
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getProductList(){
        return productService.getProductList();
    }

    @GetMapping("/products/{id_product}")
    @ResponseBody
    public Product getProduct(@PathVariable Long id_product){
        return productService.getProduct(id_product);
    }

    @DeleteMapping("/products/delete/{id_product}")
    public String deleteProduct(@PathVariable Long id_product){
        productService.deleteProduct(id_product);

        return "Product deleted successfully";
    }

    @PutMapping("/products/update")
    public String updateProduct(@RequestBody Product product){
        productService.updateProduct(product);

        return "Product updated successfully";
    }

}
