package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.mapper.IProductMapper;
import com.franncodev.salescontrol.model.Product;
import com.franncodev.salescontrol.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;

    @Override
    public ProductDTO createProduct(Product product) {
        productRepository.save(product);

        return IProductMapper.INSTANCE.productToProductDTO(product);
    }

    @Override
    public List<ProductDTO> getProductList() {
        return IProductMapper.INSTANCE.listProductToListProductDTO(productRepository.findAll());
    }

    @Override
    public Optional<ProductDTO> getProduct(Long id) {
        return productRepository.findById(id).map(IProductMapper.INSTANCE :: productToProductDTO);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO updateProduct(Product product) {
        return IProductMapper.INSTANCE.productToProductDTO(productRepository.save(product));
    }
}
