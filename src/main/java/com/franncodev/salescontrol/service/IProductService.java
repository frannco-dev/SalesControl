package com.franncodev.salescontrol.service;


import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public ProductDTO createProduct(Product product);

    public List<ProductDTO> getProductList();

    public Optional<ProductDTO> getProduct(Long id);

    public void deleteProduct(Long id);

    public ProductDTO updateProduct(Product product);

}
