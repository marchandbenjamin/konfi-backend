package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.IngredientRequest;
import com.bmarchand.konfi.repository.entities.IngredientEntity;
import com.bmarchand.konfi.service.model.Ingredient;

public interface IngredientMapper {
    Ingredient toDto(IngredientEntity entity);
    IngredientEntity toEntity(Ingredient dto);
    Ingredient toIngredient(IngredientRequest request);
}
