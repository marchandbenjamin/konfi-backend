package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.repository.entities.RecipeEntity;
import com.bmarchand.konfi.service.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RecipeMapper {

    private StepMapper stepMapper;
    private IngredientMapper ingredientMapper;

    public final RecipeEntity toEntity(Recipe dto) {
        return RecipeEntity
                .builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .steps(dto.getSteps()
                        .stream()
                        .map(step -> stepMapper.toEntity(step))
                        .toList())
                .ingredients(dto.getIngredients()
                        .stream()
                        .map(ingredient -> ingredientMapper.toEntity(ingredient))
                        .toList())
                .build();
    }

    public final Recipe toDto(RecipeEntity entity) {
        return Recipe
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .steps(entity.getSteps()
                        .stream()
                        .map(step -> stepMapper.toDto(step))
                        .toList())
                .ingredients(entity.getIngredients()
                        .stream()
                        .map(ingredient -> ingredientMapper.toDto(ingredient))
                        .toList())
                .build();
    }

    public final Recipe toRecipe(RecipeRequest request) {
        return Recipe
                .builder()
                .title(request.getTitle())
                .steps(request.getSteps()
                        .stream()
                        .map(step -> stepMapper.toStep(step))
                        .toList())
                .ingredients(request.getIngredients()
                        .stream()
                        .map(ingredient -> ingredientMapper.toIngredient(ingredient))
                        .toList())
                .build();
    }
}