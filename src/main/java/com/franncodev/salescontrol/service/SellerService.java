package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.model.Seller;
import com.franncodev.salescontrol.repository.IProductRepository;
import com.franncodev.salescontrol.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService implements ISellerService{

    @Autowired
    ISellerRepository sellerRepository;

    @Override
    public void createSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    @Override
    public List<Seller> getSellerList() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getSeller(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public void updateSeller(Seller seller) {
        sellerRepository.save(seller);
    }
}
