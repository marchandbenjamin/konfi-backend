package com.bmarchand.konfi.controller.request;

import lombok.Getter;

import java.util.List;

@Getter
public class RecipeRequest {
    private String title;
    private List<IngredientRequest> ingredients;
    private List<StepRequest> steps;
}
