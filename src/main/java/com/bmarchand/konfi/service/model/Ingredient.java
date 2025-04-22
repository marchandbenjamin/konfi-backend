package com.bmarchand.konfi.service.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Ingredient {
    private Long id;
    private String name;
    private BigDecimal quantity;
    private String unit;
}
