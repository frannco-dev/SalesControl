package com.franncodev.salescontrol.mapper;

import com.franncodev.salescontrol.dto.SellerDTO;
import com.franncodev.salescontrol.model.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ISellerMapper {

    ISellerMapper INSTANCE = Mappers.getMapper(ISellerMapper.class);

    SellerDTO sellerToSellerDTO(Seller seller);

    List<SellerDTO> listSellerToListSellerDTO(List<Seller> sellers);

}
