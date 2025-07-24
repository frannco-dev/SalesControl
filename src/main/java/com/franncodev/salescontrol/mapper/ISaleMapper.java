package com.franncodev.salescontrol.mapper;

import com.franncodev.salescontrol.dto.SaleDTO;
import com.franncodev.salescontrol.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ISaleMapper {

    ISaleMapper INSTANCE = Mappers.getMapper(ISaleMapper.class);

    SaleDTO saleToSaleDTO(Sale sale);

    List<SaleDTO> listSaleToListSaleDTO(List<Sale> sales);

}
