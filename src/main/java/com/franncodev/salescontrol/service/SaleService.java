package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.model.Product;
import com.franncodev.salescontrol.model.Sale;
import com.franncodev.salescontrol.repository.IProductRepository;
import com.franncodev.salescontrol.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements  ISaleService{

    @Autowired
    ISaleRepository saleRepository;

    @Autowired
    IProductRepository productRepository;

    @Override
    public void createSale(Sale sale) {

        Double total = 0.;
        for (Product product : sale.getProductList()){
            total = total + productRepository.findById(product.getProduct_id()).orElse(null).getValue();
        }
        sale.setTotal_price(total);
        sale.setSale_date(LocalDate.now());

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
