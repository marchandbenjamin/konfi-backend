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

    @PostMapping
    public ResponseEntity<String> createRecipe() {
        Recipe recipe = recipeService.createRecipe();
        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .body("Feature not yet implemented");
    }

    @PatchMapping
    public ResponseEntity<String> updateRecipe(@RequestBody RecipeRequest recipeRequest) {
        Recipe recipe = recipeService.updateRecipe(recipeRequest);
        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .body("Feature not yet implemented");
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public void deleteRecipe() {
        recipeService.deleteRecipe();
    }
}
