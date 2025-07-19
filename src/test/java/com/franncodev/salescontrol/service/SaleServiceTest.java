package com.franncodev.salescontrol.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.franncodev.salescontrol.model.Sale;
import com.franncodev.salescontrol.model.Seller;
import com.franncodev.salescontrol.repository.IProductRepository;
import com.franncodev.salescontrol.repository.ISaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SaleServiceTest {

    @Mock
    private ISaleRepository saleRepository;

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private SaleService saleService;

    private Sale sale;
    @BeforeEach
    void setup(){
        sale = new Sale();
        sale.setProductList(new ArrayList<>());
    }

    @DisplayName("Should create a sale successfully")
    @Test
    void testCreateSale(){
        // given
        given(saleRepository.save(any(Sale.class))).willReturn(sale);

        //when
        Sale createSale = saleService.createSale(sale);

        //then
        assertThat(createSale).isNotNull();
        verify(saleRepository, times(1)).save(any(Sale.class));
    }

    @DisplayName("Should return the list of all sales")
    @Test
    void testGetSaleList(){
        //given
        Sale sale1 = new Sale();
        sale1.setProductList(new ArrayList<>());

        given(saleRepository.findAll()).willReturn(List.of(sale,sale1));

        //when
        List<Sale> salesList = saleService.getSaleList();

        //then
        assertThat(salesList).isNotNull();
        assertThat(salesList.size()).isEqualTo(2);
    }

    @DisplayName("Should return a sale by its ID")
    @Test
    void testGetSaleById(){
        //given
        given(saleRepository.findById(sale.getSaleId())).willReturn(Optional.of(sale));

        //when
        Sale savedSale = saleService.getSale(sale.getSaleId()).get();

        //then
        assertThat(savedSale).isNotNull();
        assertThat(savedSale).isEqualTo(sale);
    }

    @DisplayName("Should update a sale successfully")
    @Test
    void testUpdateSale(){
        //given
        Seller seller = new Seller();
        seller.setFirstName("Paredes");

        given(saleRepository.save(sale)).willReturn(sale);
        sale.setTotalPrice(100.);
        sale.setSeller(seller);

        //when
        Sale savedSale = saleService.updateSale(sale);

        //then
        assertThat(sale).isNotNull();
        assertThat(savedSale.getSaleId()).isEqualTo(sale.getSaleId());
        assertThat(savedSale.getSeller().getFirstName()).isEqualTo("Paredes");
    }

    @DisplayName("Should delete a sale by its ID")
    @Test
    void testDeleteSale(){
        //given
        Long saleId = 1L;
        willDoNothing().given(saleRepository).deleteById(saleId);

        //when
        saleService.deleteSale(saleId);

        //then
        verify(saleRepository,times(1)).deleteById(saleId);
    }

}
