package com.franncodev.salescontrol.mapper;

import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    ProductDTO productToProductDTO(Product product);

    List<ProductDTO> listProductToListProductDTO(List<Product> products);

}
