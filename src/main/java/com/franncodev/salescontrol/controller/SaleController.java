package com.franncodev.salescontrol.controller;

import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.dto.SalesOnDateDTO;
import com.franncodev.salescontrol.model.Product;
import com.franncodev.salescontrol.model.Sale;
import com.franncodev.salescontrol.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SaleController {

    @Autowired
    ISaleService saleService;

    @PostMapping("/sales/create")
    public String createSale(@RequestBody Sale sale){
        saleService.createSale(sale);

        return "Sale registered successfully";
    }

    @GetMapping("/sales")
    @ResponseBody
    public List<Sale> getSaleList(){
        return saleService.getSaleList();
    }

    @GetMapping("/sales/{saleId}")
    @ResponseBody
    public Sale getSale(@PathVariable Long saleId){
        return saleService.getSale(saleId);
    }

    @DeleteMapping("/sales/delete/{saleId}")
    public String deleteSale(@PathVariable Long saleId){
        saleService.deleteSale(saleId);

        return "Sale deleted successfully";
    }

    @PutMapping("/sales/update")
    public String updateSale(@RequestBody Sale sale){
        saleService.updateSale(sale);

        return "Sale updated successfully";
    }

    @GetMapping("/sales/products/{saleId}")
    @ResponseBody
    public List<ProductDTO> getProducts_Sale(@PathVariable Long saleId){
        return saleService.getProduct_Sale(saleId);
    }

    @GetMapping("/sales/date/{saleDate}")
    @ResponseBody
    public SalesOnDateDTO getSalesOnDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saleDate){
        return saleService.getSalesOnDate(saleDate);
    }

}
