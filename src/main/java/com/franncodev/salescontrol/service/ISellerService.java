package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.model.Seller;

import java.util.List;

public interface ISellerService {

    public void createSeller(Seller seller);

    public List<Seller> getSellerList();

    public Seller getSeller(Long id);

    public void deleteSeller(Long id);

    public void updateSeller(Seller seller);

}
