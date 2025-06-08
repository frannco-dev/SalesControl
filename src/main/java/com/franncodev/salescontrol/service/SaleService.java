package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.model.Sale;
import com.franncodev.salescontrol.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements  ISaleService{

    @Autowired
    ISaleRepository saleRepository;

    @Override
    public void createSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public List<Sale> getSaleList() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSale(Long sale_id) {
        return saleRepository.findById(sale_id).orElse(null);
    }

    @Override
    public void deleteSale(Long sale_id) {
        saleRepository.deleteById(sale_id);
    }

    @Override
    public void updateSale(Sale sale) {
        saleRepository.save(sale);
    }
}
