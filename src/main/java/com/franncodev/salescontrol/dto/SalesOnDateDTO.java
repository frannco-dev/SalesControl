package com.franncodev.salescontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SalesOnDateDTO {

    private LocalDate saleDate;
    private Double totalAmount;
    private int totalSales;

}
