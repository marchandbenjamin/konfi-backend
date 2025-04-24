package com.bmarchand.konfi.controller.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class IngredientRequest {
    private String name;
    private BigDecimal quantity;
    private String unit;
}
