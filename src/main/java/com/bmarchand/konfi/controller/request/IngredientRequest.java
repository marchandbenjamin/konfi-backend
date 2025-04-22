package com.bmarchand.konfi.controller.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class IngredientRequest {
    private String name;
    private BigDecimal quantity;
    private String unit;
}
