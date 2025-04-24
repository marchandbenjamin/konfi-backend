package com.bmarchand.konfi.mapper;

import com.bmarchand.konfi.controller.request.StepRequest;
import com.bmarchand.konfi.fixture.RecipeFixture;
import com.bmarchand.konfi.repository.entities.RecipeEntity;
import com.bmarchand.konfi.repository.entities.StepEntity;
import com.bmarchand.konfi.service.model.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepMapperTest {

    private StepMapper stepMapper;

    @BeforeEach
    void setUp() {
        stepMapper = new StepMapper();
    }

    @Test
    void testToEntity() {
        // Arrange
        Step dto = RecipeFixture.getValidStep();

        StepEntity expectedEntity = RecipeFixture.getValidStepEntity();

        // Act
        StepEntity result = stepMapper.toEntity(dto.getId(), dto);

        // Assert
        assertEquals(expectedEntity.getId(), result.getId());
        assertEquals(expectedEntity.getDescription(), result.getDescription());
        assertEquals(expectedEntity.getStepOrder(), result.getStepOrder());
    }

    @Test
    void testToDto() {
        // Arrange
        Step expectedDto = RecipeFixture.getValidStep();

        StepEntity entity = RecipeFixture.getValidStepEntity();

        // Act
        Step result = stepMapper.toDto(entity);

        // Assert
        assertEquals(expectedDto.getId(), result.getId());
        assertEquals(expectedDto.getDescription(), result.getDescription());
        assertEquals(expectedDto.getStepOrder(), result.getStepOrder());
    }

    @Test
    void testToStep() {
        // Arrange
        Step expectedDto = RecipeFixture.getValidStep();

        StepRequest request = RecipeFixture.getValidStepRequest();

        // Act
        Step result = stepMapper.toStep(request);

        // Assert
        assertEquals(expectedDto.getId(), result.getId());
        assertEquals(expectedDto.getDescription(), result.getDescription());
        assertEquals(expectedDto.getStepOrder(), result.getStepOrder());
    }
}