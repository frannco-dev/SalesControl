package com.franncodev.salescontrol.repository;


import com.franncodev.salescontrol.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISellerRepository extends JpaRepository<Seller, Long> {
}