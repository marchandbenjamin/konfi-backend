package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.IngredientRequest;
import com.bmarchand.konfi.repository.entities.IngredientEntity;
import com.bmarchand.konfi.service.model.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    IngredientEntity toEntity(Ingredient dto) {
        return IngredientEntity
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .unit(dto.getUnit())
                .build();
    }

    Ingredient toDto(IngredientEntity entity) {
        return Ingredient
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .quantity(entity.getQuantity())
                .unit(entity.getUnit())
                .build();
    }

    Ingredient toIngredient(IngredientRequest request) {
        return Ingredient
                .builder()
                .name(request.getName())
                .quantity(request.getQuantity())
                .unit(request.getUnit())
                .build();
    }
}
