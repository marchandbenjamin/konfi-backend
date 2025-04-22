package com.bmarchand.konfi.service;

import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.repository.RecipeRepository;
import com.bmarchand.konfi.service.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeService {

    private RecipeRepository recipeRepository;

    public Recipe getRecipe() {
        return null;
    }

    public Recipe createRecipe() {
        return null;
    }

    public Recipe updateRecipe(RecipeRequest request) {
        return null;
    }

    public void deleteRecipe() {
    }
}
