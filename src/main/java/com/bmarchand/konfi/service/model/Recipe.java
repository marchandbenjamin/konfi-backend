package com.bmarchand.konfi.service.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Recipe {
    private Long id;
    private String title;
    private List<Step> steps;
    private List<Ingredient> ingredients;
}
