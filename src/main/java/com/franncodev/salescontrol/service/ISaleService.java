package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.dto.SaleDTO;
import com.franncodev.salescontrol.dto.SalesOnDateDTO;
import com.franncodev.salescontrol.model.Sale;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ISaleService {

    public SaleDTO createSale(Sale sale);

    public List<SaleDTO> getSaleList();

    public Optional<SaleDTO> getSale(Long sale_id);

    public void deleteSale(Long sale_id);

    public SaleDTO updateSale(Sale sale);

    List<ProductDTO> getProduct_Sale(Long sale_id);

    SalesOnDateDTO getSalesOnDate(LocalDate date);
}
