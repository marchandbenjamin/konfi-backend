package com.bmarchand.konfi.service;

import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.exception.RecipeNotFoundException;
import com.bmarchand.konfi.mapper.RecipeMapper;
import com.bmarchand.konfi.repository.RecipeRepository;
import com.bmarchand.konfi.repository.entities.IngredientEntity;
import com.bmarchand.konfi.repository.entities.RecipeEntity;
import com.bmarchand.konfi.repository.entities.StepEntity;
import com.bmarchand.konfi.service.model.Recipe;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class RecipeService {

    private RecipeRepository recipeRepository;
    private RecipeMapper recipeMapper;

    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    public Recipe getRecipeById(Long recipeId) {
        RecipeEntity recipeEntity = recipeRepository.findById(recipeId).orElseThrow(() -> new RecipeNotFoundException(recipeId));
        return recipeMapper.toDto(recipeEntity);
    }

    public Recipe createRecipe(RecipeRequest recipeRequest) {
        Recipe recipe = recipeMapper.toRecipe(recipeRequest);
        RecipeEntity recipeEntity = recipeMapper.toEntity(recipe);
        RecipeEntity savedRecipe = recipeRepository.save(recipeEntity);
        return recipeMapper.toDto(savedRecipe);
    }

    @Transactional
    public Recipe updateRecipe(Long recipeId, RecipeRequest request) {
        RecipeEntity recipeEntity = recipeRepository.findById(recipeId).orElseThrow(() -> new RecipeNotFoundException(recipeId));

        Recipe recipe = recipeMapper.toRecipe(request);
        RecipeEntity mappedEntity = recipeMapper.toEntity(recipe);

        updateExistingRecipeEntity(recipeEntity, mappedEntity);

        RecipeEntity updatedEntity = recipeRepository.findById(recipeId).orElseThrow(() -> new RecipeNotFoundException(recipeId));
        return recipeMapper.toDto(updatedEntity);
    }

    private void updateExistingRecipeEntity(RecipeEntity toUpdateRecipeEntity, RecipeEntity newDataRecipeEntity) {
        toUpdateRecipeEntity.setTitle(newDataRecipeEntity.getTitle());
        updateExistingIngredientEntity(toUpdateRecipeEntity.getIngredients(), newDataRecipeEntity.getIngredients());
        updateExistingStepEntity(toUpdateRecipeEntity.getSteps(), newDataRecipeEntity.getSteps());
    }

    private void updateExistingStepEntity(List<StepEntity> toUpdateStepEntities, List<StepEntity> newDataStepEntity) {
        IntStream.range(0, toUpdateStepEntities.size())
                .forEach(i -> {
                    StepEntity target = toUpdateStepEntities.get(i);
                    StepEntity source = newDataStepEntity.get(i);
                    target.setDescription(source.getDescription());
                    target.setStepOrder(source.getStepOrder());
                });
    }

    private void updateExistingIngredientEntity(List<IngredientEntity> toUpdateIngredientEntities, List<IngredientEntity> newDataIngredientEntity) {
        IntStream.range(0, toUpdateIngredientEntities.size())
                .forEach(i -> {
                    IngredientEntity target = toUpdateIngredientEntities.get(i);
                    IngredientEntity source = newDataIngredientEntity.get(i);
                    target.setUnit(source.getUnit());
                    target.setName(source.getName());
                    target.setQuantity(source.getQuantity());
                });
    }

    public void deleteRecipe(Long recipeId) {
        recipeRepository.findById(recipeId).orElseThrow(() -> new RecipeNotFoundException(recipeId));
        recipeRepository.deleteById(recipeId);
    }
}
