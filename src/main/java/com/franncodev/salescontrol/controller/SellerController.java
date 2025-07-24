package com.franncodev.salescontrol.controller;

import com.franncodev.salescontrol.dto.SellerDTO;
import com.franncodev.salescontrol.mapper.ISellerMapper;
import com.franncodev.salescontrol.model.Seller;
import com.franncodev.salescontrol.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    ISellerService sellerService;

    @PostMapping("/create")
    public ResponseEntity<SellerDTO> createSeller(@RequestBody Seller seller){
        SellerDTO createdSeller = sellerService.createSeller(seller);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeller);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<SellerDTO>> getSellerList(){
        return ResponseEntity.ok(sellerService.getSellerList());
    }

    @GetMapping("/{sellerId}")
    @ResponseBody
    public ResponseEntity<Optional<SellerDTO>> getSeller(@PathVariable Long sellerId){
        return ResponseEntity.ok(sellerService.getSeller(sellerId));
    }

    @DeleteMapping("/delete/{sellerId}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long sellerId){
        sellerService.deleteSeller(sellerId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<SellerDTO> updateSeller(@RequestBody Seller seller){
        return ResponseEntity.ok(sellerService.updateSeller(seller));
    }

}
