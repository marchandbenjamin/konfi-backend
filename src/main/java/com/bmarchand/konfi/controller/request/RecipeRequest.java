package com.bmarchand.konfi.controller.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecipeRequest {
    private String title;
    private List<IngredientRequest> ingredients;
    private List<StepRequest> steps;
}
