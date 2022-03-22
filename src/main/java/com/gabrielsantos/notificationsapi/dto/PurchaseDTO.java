package com.gabrielsantos.notificationsapi.dto;

import com.gabrielsantos.notificationsapi.enums.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseDTO {

    private Long id;

    private Product product;

    private BigDecimal price;

    private String buyerName;

    private String buyerSSN;

    private String buyerEmail;

    private String buyerPostalCode;

    private Long purchaseDate;

    private CreditCardDTO creditCardDTO;

}
