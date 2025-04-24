package com.bmarchand.konfi.service;

import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.exception.RecipeNotFoundException;
import com.bmarchand.konfi.fixture.RecipeFixture;
import com.bmarchand.konfi.mapper.RecipeMapper;
import com.bmarchand.konfi.repository.RecipeRepository;
import com.bmarchand.konfi.repository.entities.RecipeEntity;
import com.bmarchand.konfi.service.model.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private RecipeMapper recipeMapper;

    @InjectMocks
    private RecipeService recipeService;

    @Test
    void getAllRecipe_should_return_all_recipes() {
        // Arrange
        RecipeEntity validRecipeEntity = RecipeFixture.getValidRecipeEntity();

        Recipe validRecipe = RecipeFixture.getValidRecipe();

        Mockito.when(recipeRepository.findAll()).thenReturn(List.of(validRecipeEntity));
        Mockito.when(recipeMapper.toDto(validRecipeEntity)).thenReturn(validRecipe);

        // Act
        List<Recipe> result = recipeService.getAllRecipe();

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(validRecipe);
        Mockito.verify(recipeRepository).findAll();
        Mockito.verify(recipeMapper).toDto(validRecipeEntity);
    }

    @Test
    void getRecipeById_should_return_recipe_when_recipe_exists() {
        // Arrange
        Long recipeId = 1L;
        RecipeEntity validRecipeEntity = RecipeFixture.getValidRecipeEntity();
        Recipe validRecipe = RecipeFixture.getValidRecipe();

        Mockito.when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(validRecipeEntity));
        Mockito.when(recipeMapper.toDto(validRecipeEntity)).thenReturn(validRecipe);

        // Act
        Recipe result = recipeService.getRecipeById(recipeId);

        // Assert
        assertThat(result).isEqualTo(validRecipe);
        Mockito.verify(recipeRepository).findById(recipeId);
        Mockito.verify(recipeMapper).toDto(validRecipeEntity);
    }

    @Test
    void getRecipeById_should_throw_exception_when_recipe_does_not_exist() {
        // Arrange
        Long recipeId = 999L;
        Mockito.when(recipeRepository.findById(recipeId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> recipeService.getRecipeById(recipeId))
                .isInstanceOf(RecipeNotFoundException.class)
                .hasMessageContaining(recipeId.toString());

        Mockito.verify(recipeRepository).findById(recipeId);
        Mockito.verifyNoInteractions(recipeMapper);
    }


    @Test
    void createRecipe_should_save_and_return_recipe() {
        // Arrange
        RecipeRequest recipeRequest = RecipeFixture.getValidRecipeRequest();
        Recipe recipe = RecipeFixture.getValidRecipe();
        RecipeEntity recipeEntity = RecipeFixture.getValidRecipeEntity();
        RecipeEntity savedRecipeEntity = RecipeFixture.getValidRecipeEntity();
        Recipe expectedRecipe = RecipeFixture.getValidRecipe();

        Mockito.when(recipeMapper.toRecipe(recipeRequest)).thenReturn(recipe);
        Mockito.when(recipeMapper.toEntity(recipe)).thenReturn(recipeEntity);
        Mockito.when(recipeRepository.save(recipeEntity)).thenReturn(savedRecipeEntity);
        Mockito.when(recipeMapper.toDto(savedRecipeEntity)).thenReturn(expectedRecipe);

        // Act
        Recipe result = recipeService.createRecipe(recipeRequest);

        // Assert
        assertThat(result).isEqualTo(expectedRecipe);
        Mockito.verify(recipeMapper).toRecipe(recipeRequest);
        Mockito.verify(recipeMapper).toEntity(recipe);
        Mockito.verify(recipeRepository).save(recipeEntity);
        Mockito.verify(recipeMapper).toDto(savedRecipeEntity);
    }

    @Test
    void updateRecipe_shouldUpdateEntityAndReturnUpdatedDto() {
        // Arrange
        Long recipeId = 1L;
        RecipeRequest request = RecipeFixture.getValidRecipeRequest();
        Recipe recipe = RecipeFixture.getValidRecipe();
        RecipeEntity existingEntity = RecipeFixture.getValidRecipeEntity();
        RecipeEntity mappedEntity = RecipeFixture.getValidRecipeEntity();
        Recipe expectedDto = RecipeFixture.getValidRecipe();

        Mockito.when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(existingEntity));
        Mockito.when(recipeMapper.toRecipe(request)).thenReturn(recipe);
        Mockito.when(recipeMapper.toEntity(recipe)).thenReturn(mappedEntity);

        Mockito.when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(existingEntity));
        Mockito.when(recipeMapper.toDto(existingEntity)).thenReturn(expectedDto);

        // Act
        Recipe result = recipeService.updateRecipe(recipeId, request);

        // Assert
        assertThat(result).isEqualTo(expectedDto);
        Mockito.verify(recipeRepository, Mockito.times(2)).findById(recipeId);
        Mockito.verify(recipeMapper).toRecipe(request);
        Mockito.verify(recipeMapper).toEntity(recipe);
        Mockito.verify(recipeMapper).toDto(existingEntity);

        assertThat(existingEntity.getTitle()).isEqualTo(mappedEntity.getTitle());
        assertThat(existingEntity.getIngredients()).usingRecursiveComparison().isEqualTo(mappedEntity.getIngredients());
        assertThat(existingEntity.getSteps()).usingRecursiveComparison().isEqualTo(mappedEntity.getSteps());
    }

    @Test
    void updateRecipe_shouldThrowException_whenRecipeNotFound() {
        // Arrange
        Long recipeId = 999L;
        RecipeRequest request = RecipeFixture.getValidRecipeRequest();

        Mockito.when(recipeRepository.findById(recipeId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> recipeService.updateRecipe(recipeId, request))
                .isInstanceOf(RecipeNotFoundException.class)
                .hasMessageContaining(recipeId.toString());

        Mockito.verify(recipeRepository).findById(recipeId);
        Mockito.verifyNoMoreInteractions(recipeMapper);
    }

    @Test
    void deleteRecipe_should_delete_recipe_when_recipe_exists() {
        // Arrange
        Long recipeId = 1L;
        RecipeEntity recipeEntity = RecipeFixture.getValidRecipeEntity();

        Mockito.when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(recipeEntity));

        // Act
        recipeService.deleteRecipe(recipeId);

        // Assert
        Mockito.verify(recipeRepository).findById(recipeId);
        Mockito.verify(recipeRepository).deleteById(recipeId);
    }
    @Test
    void deleteRecipe_should_throw_exception_when_recipe_does_not_exist() {
        // Arrange
        Long recipeId = 999L;
        Mockito.when(recipeRepository.findById(recipeId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> recipeService.deleteRecipe(recipeId))
                .isInstanceOf(RecipeNotFoundException.class)
                .hasMessageContaining(recipeId.toString());

        Mockito.verify(recipeRepository).findById(recipeId);
        Mockito.verify(recipeRepository, Mockito.never()).deleteById(Mockito.anyLong());
    }

}