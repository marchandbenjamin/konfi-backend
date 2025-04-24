package com.bmarchand.konfi.service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Ingredient {
    private Long id;
    private String name;
    private BigDecimal quantity;
    private String unit;
}
