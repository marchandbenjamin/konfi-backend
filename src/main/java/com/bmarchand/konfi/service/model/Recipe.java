package com.bmarchand.konfi.service.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Recipe {
    private Long id;
    private String title;
    private List<Ingredient> ingredients;
    private List<Step> steps;
}
