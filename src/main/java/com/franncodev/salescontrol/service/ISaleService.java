package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.model.Sale;

import java.util.List;

public interface ISaleService {

    public void createSale(Sale sale);

    public List<Sale> getSaleList();

    public Sale getSale(Long sale_id);

    public void deleteSale(Long sale_id);

    public void updateSale(Sale sale);

    List<ProductDTO> getProduct_Sale(Long sale_id);
}
