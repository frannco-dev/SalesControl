package com.franncodev.salescontrol.service;


import com.franncodev.salescontrol.model.Product;

import java.util.List;

public interface IProductService {

    public void createProduct(Product product);

    public List<Product> getProductList();

    public Product getProduct(Long id);

    public void deleteProduct(Long id);

    public void updateProduct(Product product);

}
