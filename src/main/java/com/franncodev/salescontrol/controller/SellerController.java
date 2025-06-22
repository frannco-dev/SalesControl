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

    @GetMapping("/sellers/{sellerId}")
    @ResponseBody
    public Seller getSeller(@PathVariable Long idSeller){
        return sellerService.getSeller(idSeller);
    }

    @DeleteMapping("/sellers/delete/{sellerId}")
    public String deleteSeller(@PathVariable Long idSeller){
        sellerService.deleteSeller(idSeller);

        return "Seller deleted successfully";
    }

    @PutMapping("/sellers/update")
    public String updateSeller(@RequestBody Seller seller){
        sellerService.updateSeller(seller);

        return "Seller updated successfully";
    }

}
