package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.repository.entities.IngredientEntity;
import com.bmarchand.konfi.repository.entities.RecipeEntity;
import com.bmarchand.konfi.repository.entities.StepEntity;
import com.bmarchand.konfi.service.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RecipeMapper {

    private StepMapper stepMapper;
    private IngredientMapper ingredientMapper;

    public final RecipeEntity toEntity(Recipe dto) {
        RecipeEntity recipeEntity = RecipeEntity
                .builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .build();

        List<StepEntity> stepEntityList = dto.getSteps()
                .stream()
                .map(step -> stepMapper.toEntity(recipeEntity.getId(), step))
                .toList();
        recipeEntity.setSteps(stepEntityList);

        List<IngredientEntity> ingredientEntityList = dto.getIngredients()
                .stream()
                .map(ingredient -> ingredientMapper.toEntity(recipeEntity.getId(), ingredient))
                .toList();
        recipeEntity.setIngredients(ingredientEntityList);
        return recipeEntity;
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