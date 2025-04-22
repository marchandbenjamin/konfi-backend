package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.RecipeRequest;
import com.bmarchand.konfi.repository.entities.RecipeEntity;
import com.bmarchand.konfi.service.model.Recipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    Recipe toDto(RecipeEntity entity);
    RecipeEntity toEntity(Recipe dto);
    Recipe toRecipe(RecipeRequest request);
}