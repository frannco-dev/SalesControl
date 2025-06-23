package com.franncodev.salescontrol.repository;

import com.franncodev.salescontrol.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllBySaleDate(LocalDate date);
}
