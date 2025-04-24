package com.bmarchand.konfi.controller;

import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.service.RecipeService;
import com.bmarchand.konfi.service.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
@AllArgsConstructor
public class RecipeController {

    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipe() {
        List<Recipe> allRecipe = recipeService.getAllRecipe();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allRecipe);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long recipeId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recipeService.getRecipeById(recipeId));
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeRequest recipeRequest) {
        Recipe recipe = recipeService.createRecipe(recipeRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(recipe);
    }

    @PatchMapping("/{recipeId}")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable Long recipeId,
            @RequestBody RecipeRequest recipeRequest) {
        Recipe recipe = recipeService.updateRecipe(recipeId, recipeRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recipe);
    }

    @DeleteMapping("/{recipeId}")
    public void deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteRecipe(recipeId);
    }
}
