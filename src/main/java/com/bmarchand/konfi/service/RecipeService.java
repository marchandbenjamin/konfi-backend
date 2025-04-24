package com.bmarchand.konfi.service;

import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.exception.RecipeNotFoundException;
import com.bmarchand.konfi.mapper.RecipeMapper;
import com.bmarchand.konfi.repository.RecipeRepository;
import com.bmarchand.konfi.repository.entities.RecipeEntity;
import com.bmarchand.konfi.service.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        RecipeEntity recipeEntity = recipeRepository.findById(recipeId).orElseThrow();
        return recipeMapper.toDto(recipeEntity);
    }

    public Recipe createRecipe() {
        return null;
    }

    public Recipe updateRecipe(RecipeRequest request) {
        return null;
    }

    public void deleteRecipe(Long recipeId) {
        if (recipeRepository.findById(recipeId).isEmpty()) throw new RecipeNotFoundException(recipeId);
        recipeRepository.deleteById(recipeId);
    }
}
