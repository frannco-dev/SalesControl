package com.franncodev.salescontrol.controller;

import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.model.Product;
import com.franncodev.salescontrol.model.Sale;
import com.franncodev.salescontrol.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/sales/{sale_id}")
    @ResponseBody
    public Sale getSale(@PathVariable Long sale_id){
        return saleService.getSale(sale_id);
    }

    @DeleteMapping("/sales/delete/{sale_id}")
    public String deleteSale(@PathVariable Long sale_id){
        saleService.deleteSale(sale_id);

        return "Sale deleted successfully";
    }

    @PutMapping("/sales/update")
    public String updateSale(@RequestBody Sale sale){
        saleService.updateSale(sale);

        return "Sale updated successfully";
    }

    @GetMapping("/sales/products/{sale_id}")
    @ResponseBody
    public List<ProductDTO> getProducts_Sale(@PathVariable Long sale_id){
        return saleService.getProduct_Sale(sale_id);
    }

}
