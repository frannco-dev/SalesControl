package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.dto.SellerDTO;
import com.franncodev.salescontrol.model.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerService {

    public SellerDTO createSeller(Seller seller);

    public List<SellerDTO> getSellerList();

    public Optional<SellerDTO> getSeller(Long id);

    public void deleteSeller(Long id);

    public SellerDTO updateSeller(Seller seller);

}
