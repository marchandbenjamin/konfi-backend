package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.IngredientRequest;
import com.bmarchand.konfi.fixture.RecipeFixture;
import com.bmarchand.konfi.repository.entities.IngredientEntity;
import com.bmarchand.konfi.service.model.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientMapperTest {

    private IngredientMapper ingredientMapper;

    @BeforeEach
    void setUp() {
        ingredientMapper = new IngredientMapper();
    }

    @Test
    void testToEntity() {
        // Arrange
        Ingredient dto = RecipeFixture.getValidIngredient();

        IngredientEntity expectedEntity = RecipeFixture.getValidIngredientEntity();

        // Act
        IngredientEntity result = ingredientMapper.toEntity(dto);

        // Assert
        assertEquals(expectedEntity.getId(), result.getId());
        assertEquals(expectedEntity.getName(), result.getName());
        assertEquals(expectedEntity.getQuantity(), result.getQuantity());
        assertEquals(expectedEntity.getUnit(), result.getUnit());
    }

    @Test
    void testToDto() {
        // Arrange
        Ingredient expectedDto = RecipeFixture.getValidIngredient();

        IngredientEntity entity = RecipeFixture.getValidIngredientEntity();

        // Act
        Ingredient result = ingredientMapper.toDto(entity);

        // Assert
        assertEquals(expectedDto.getId(), result.getId());
        assertEquals(expectedDto.getName(), result.getName());
        assertEquals(expectedDto.getQuantity(), result.getQuantity());
        assertEquals(expectedDto.getUnit(), result.getUnit());
    }

    @Test
    void testToIngredient() {
        // Arrange
        Ingredient expectedDto = RecipeFixture.getValidIngredient();

        IngredientRequest request = RecipeFixture.getValidIngredientRequest();

        // Act
        Ingredient result = ingredientMapper.toIngredient(request);

        // Assert
        assertEquals(expectedDto.getId(), result.getId());
        assertEquals(expectedDto.getName(), result.getName());
        assertEquals(expectedDto.getQuantity(), result.getQuantity());
        assertEquals(expectedDto.getUnit(), result.getUnit());
    }
}