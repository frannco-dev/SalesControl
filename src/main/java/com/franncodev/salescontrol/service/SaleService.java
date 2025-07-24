package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.dto.SaleDTO;
import com.franncodev.salescontrol.dto.SalesOnDateDTO;
import com.franncodev.salescontrol.mapper.IProductMapper;
import com.franncodev.salescontrol.mapper.ISaleMapper;
import com.franncodev.salescontrol.model.Product;
import com.franncodev.salescontrol.model.Sale;
import com.franncodev.salescontrol.repository.IProductRepository;
import com.franncodev.salescontrol.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService implements  ISaleService{

    @Autowired
    ISaleRepository saleRepository;

    @Autowired
    IProductRepository productRepository;

    @Override
    public SaleDTO createSale(Sale sale) {

        Double total = 0.;
        for (Product product : sale.getProductList()){
            total = total + productRepository.findById(product.getProductId()).orElse(null).getValue();
        }
        sale.setTotalPrice(total);
        sale.setSaleDate(LocalDate.now());

        return ISaleMapper.INSTANCE.saleToSaleDTO(saleRepository.save(sale));
    }

    @Override
    public List<SaleDTO> getSaleList() {
        return ISaleMapper.INSTANCE.listSaleToListSaleDTO(saleRepository.findAll());
    }

    @Override
    public Optional<SaleDTO> getSale(Long sale_id) {
        return saleRepository.findById(sale_id).map(ISaleMapper.INSTANCE :: saleToSaleDTO);
    }

    @Override
    public void deleteSale(Long sale_id) {
        saleRepository.deleteById(sale_id);
    }

    @Override
    public SaleDTO updateSale(Sale sale) {
        return ISaleMapper.INSTANCE.saleToSaleDTO(saleRepository.save(sale));
    }

    @Override
    public List<ProductDTO> getProduct_Sale(Long sale_id) {

        Sale sale = saleRepository.findById(sale_id).orElse(null);

        return IProductMapper.INSTANCE.listProductToListProductDTO(sale.getProductList());
    }

    @Override
    public SalesOnDateDTO getSalesOnDate(LocalDate date) {
        List<Sale> salesOnDate = saleRepository.findAllBySaleDate(date);

        int totalSales = salesOnDate.size();

        Double totalAmount = salesOnDate.stream().mapToDouble(Sale::getTotalPrice).sum();

        return new SalesOnDateDTO(date, totalAmount, totalSales);
    }
}
