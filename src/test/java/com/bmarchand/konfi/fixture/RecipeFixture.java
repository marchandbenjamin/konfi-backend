package com.bmarchand.konfi.fixture;

import com.bmarchand.konfi.controller.request.IngredientRequest;
import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.controller.request.StepRequest;
import com.bmarchand.konfi.repository.entities.IngredientEntity;
import com.bmarchand.konfi.repository.entities.RecipeEntity;
import com.bmarchand.konfi.repository.entities.StepEntity;
import com.bmarchand.konfi.service.model.Ingredient;
import com.bmarchand.konfi.service.model.Recipe;
import com.bmarchand.konfi.service.model.Step;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.List;

public class RecipeFixture {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static RecipeRequest getValidRecipeRequest() {
        return RecipeRequest.builder()
                .title("Test Recipe")
                .steps(List.of(getValidStepRequest()))
                .ingredients(List.of(getValidIngredientRequest()))
                .build();
    }

    public static StepRequest getValidStepRequest() {
        return StepRequest
                .builder()
                .description("Test Step")
                .stepOrder(0)
                .build();
    }

    public static IngredientRequest getValidIngredientRequest() {
        return IngredientRequest
                .builder()
                .name("Test Ingredient")
                .unit("Test Unit")
                .quantity(new BigDecimal("1.000"))
                .build();
    }

    public static Recipe getValidRecipe() {
        return Recipe
                .builder()
                .id(1L)
                .title("Test Recipe")
                .steps(List.of(getValidStep()))
                .ingredients(List.of(getValidIngredient()))
                .build();
    }

    public static Step getValidStep() {
        return Step
                .builder()
                .description("Test Step")
                .stepOrder(0)
                .build();
    }

    public static Ingredient getValidIngredient() {
        return Ingredient
                .builder()
                .name("Test Ingredient")
                .unit("Test Unit")
                .quantity(new BigDecimal("1.000"))
                .build();
    }

    public static RecipeEntity getValidRecipeEntity() {
        return RecipeEntity.builder()
                .id(1L)
                .title("Test Recipe")
                .steps(List.of(getValidStepEntity()))
                .ingredients(List.of(getValidIngredientEntity()))
                .build();
    }

    public static StepEntity getValidStepEntity() {
        return StepEntity
                .builder()
                .description("Test Step")
                .stepOrder(0)
                .build();
    }

    public static IngredientEntity getValidIngredientEntity() {
        return IngredientEntity
                .builder()
                .name("Test Ingredient")
                .unit("Test Unit")
                .quantity(new BigDecimal("1.000"))
                .build();
    }
}
