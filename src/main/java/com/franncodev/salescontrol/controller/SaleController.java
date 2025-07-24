package com.franncodev.salescontrol.controller;

import com.franncodev.salescontrol.dto.ProductDTO;
import com.franncodev.salescontrol.dto.SaleDTO;
import com.franncodev.salescontrol.dto.SalesOnDateDTO;
import com.franncodev.salescontrol.model.Product;
import com.franncodev.salescontrol.model.Sale;
import com.franncodev.salescontrol.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    ISaleService saleService;

    @PostMapping("/create")
    public ResponseEntity<SaleDTO> createSale(@RequestBody Sale sale){
        SaleDTO createdSale = saleService.createSale(sale);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdSale);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<SaleDTO>> getSaleList(){
        return ResponseEntity.ok(saleService.getSaleList());
    }

    @GetMapping("/{saleId}")
    @ResponseBody
    public ResponseEntity<Optional<SaleDTO>> getSale(@PathVariable Long saleId){
        return ResponseEntity.ok(saleService.getSale(saleId));
    }

    @DeleteMapping("/delete/{saleId}")
        public ResponseEntity<Void> deleteSale(@PathVariable Long saleId){
        saleService.deleteSale(saleId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<SaleDTO> updateSale(@RequestBody Sale sale){
        return ResponseEntity.ok(saleService.updateSale(sale));
    }

    @GetMapping("/products/{saleId}")
    @ResponseBody
    public ResponseEntity<List<ProductDTO>> getProductsOfSale(@PathVariable Long saleId){
        return ResponseEntity.ok(saleService.getProduct_Sale(saleId));
    }

    @GetMapping("/date/{saleDate}")
    @ResponseBody
    public ResponseEntity<SalesOnDateDTO> getSalesOnDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saleDate){
        return ResponseEntity.ok(saleService.getSalesOnDate(saleDate));
    }

}
