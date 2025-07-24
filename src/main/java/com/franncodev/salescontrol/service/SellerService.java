package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.dto.SellerDTO;
import com.franncodev.salescontrol.mapper.ISellerMapper;
import com.franncodev.salescontrol.model.Seller;
import com.franncodev.salescontrol.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService implements ISellerService{

    @Autowired
    ISellerRepository sellerRepository;

    @Override
    public SellerDTO createSeller(Seller seller) {
        // primera letra del nombre + indices 2,3,4 de idCard + primera letra del apellido
        // first letters of the first name + characters 2,3,4 from idCard + first letter of the last name
        seller.setSellerId(seller.getFirstName().substring(0,1).concat(seller.getIdCard().substring(2,5)).concat(seller.getLastName().substring(0,1)));

        return ISellerMapper.INSTANCE.sellerToSellerDTO(sellerRepository.save(seller));
    }

    @Override
    public List<SellerDTO> getSellerList() {
        return ISellerMapper.INSTANCE.listSellerToListSellerDTO(sellerRepository.findAll());
    }

    @Override
    public Optional<SellerDTO> getSeller(Long id) {
        return sellerRepository.findById(id).map(ISellerMapper.INSTANCE :: sellerToSellerDTO);
    }

    @Override
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public SellerDTO updateSeller(Seller seller) {
        return ISellerMapper.INSTANCE.sellerToSellerDTO(sellerRepository.save(seller));
    }
}
