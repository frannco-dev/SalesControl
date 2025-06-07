package com.franncodev.salescontrol.controller;

import com.franncodev.salescontrol.model.Seller;
import com.franncodev.salescontrol.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {

    @Autowired
    ISellerService sellerService;

    @PostMapping("/sellers/create")
    public String createSeller(@RequestBody Seller seller){
        sellerService.createSeller(seller);

        return "Seller created successfully";
    }

    @GetMapping("/sellers")
    @ResponseBody
    public List<Seller> getSellerList(){
        return sellerService.getSellerList();
    }

    @GetMapping("/sellers/{id_seller}")
    @ResponseBody
    public Seller getSeller(@PathVariable Long id_seller){
        return sellerService.getSeller(id_seller);
    }

    @DeleteMapping("/sellers/delete/{id_seller}")
    public String deleteSeller(@PathVariable Long id_seller){
        sellerService.deleteSeller(id_seller);

        return "Seller deleted successfully";
    }

    @PutMapping("/sellers/update")
    public String updateSeller(@RequestBody Seller seller){
        sellerService.updateSeller(seller);

        return "Seller updated successfully";
    }

}
