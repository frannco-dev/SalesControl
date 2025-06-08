package com.franncodev.salescontrol.repository;

import com.franncodev.salescontrol.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
}
