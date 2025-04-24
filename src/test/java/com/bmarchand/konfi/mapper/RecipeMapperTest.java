package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.IngredientRequest;
import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.controller.request.StepRequest;
import com.bmarchand.konfi.fixture.RecipeFixture;
import com.bmarchand.konfi.repository.RecipeRepository;
import com.bmarchand.konfi.repository.entities.IngredientEntity;
import com.bmarchand.konfi.repository.entities.RecipeEntity;
import com.bmarchand.konfi.repository.entities.StepEntity;
import com.bmarchand.konfi.service.model.Ingredient;
import com.bmarchand.konfi.service.model.Recipe;
import com.bmarchand.konfi.service.model.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeMapperTest {

    private RecipeMapper recipeMapper;
    private StepMapper stepMapper;
    private IngredientMapper ingredientMapper;

    @BeforeEach
    void setUp() {
        stepMapper = Mockito.mock(StepMapper.class);
        ingredientMapper = Mockito.mock(IngredientMapper.class);
        recipeMapper = new RecipeMapper(stepMapper, ingredientMapper);
    }

    @Test
    void testToEntity() {
        // Arrange
        Recipe dto = RecipeFixture.getValidRecipe();

        RecipeEntity expectedEntity = RecipeFixture.getValidRecipeEntity();

        Mockito.when(stepMapper.toEntity(Mockito.any(Step.class))).thenReturn(StepEntity.builder().build());
        Mockito.when(ingredientMapper.toEntity(Mockito.any(Ingredient.class))).thenReturn(IngredientEntity.builder().build());

        // Act
        RecipeEntity result = recipeMapper.toEntity(dto);

        // Assert
        assertEquals(expectedEntity.getId(), result.getId());
        assertEquals(expectedEntity.getTitle(), result.getTitle());
        assertEquals(1, result.getSteps().size());
        assertEquals(1, result.getIngredients().size());
    }

    @Test
    void testToDto() {
        // Arrange
        Recipe expectedDto = RecipeFixture.getValidRecipe();

        RecipeEntity entity = RecipeFixture.getValidRecipeEntity();

        Mockito.when(stepMapper.toDto(Mockito.any(StepEntity.class))).thenReturn(Step.builder().build());
        Mockito.when(ingredientMapper.toDto(Mockito.any(IngredientEntity.class))).thenReturn(Ingredient.builder().build());

        // Act
        Recipe result = recipeMapper.toDto(entity);

        // Assert
        assertEquals(expectedDto.getId(), result.getId());
        assertEquals(expectedDto.getTitle(), result.getTitle());
        assertEquals(1, result.getSteps().size());
        assertEquals(1, result.getIngredients().size());
    }

    @Test
    void testToRecipe() {
        // Arrange
        Recipe expectedRecipe = RecipeFixture.getValidRecipe();

        RecipeRequest request = RecipeFixture.getValidRecipeRequest();

        Mockito.when(stepMapper.toStep(Mockito.any(StepRequest.class))).thenReturn(Step.builder().build());
        Mockito.when(ingredientMapper.toIngredient(Mockito.any(IngredientRequest.class))).thenReturn(Ingredient.builder().build());

        // Act
        Recipe result = recipeMapper.toRecipe(request);

        // Assert
        assertNull(result.getId());
        assertEquals(expectedRecipe.getTitle(), result.getTitle());
        assertEquals(1, result.getSteps().size());
        assertEquals(1, result.getIngredients().size());
    }
}
